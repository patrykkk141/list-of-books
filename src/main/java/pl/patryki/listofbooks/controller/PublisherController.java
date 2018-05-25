package pl.patryki.listofbooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.patryki.listofbooks.dto.PublisherDto;
import pl.patryki.listofbooks.exceptions.NotFoundException;
import pl.patryki.listofbooks.model.Publisher;
import pl.patryki.listofbooks.service.PublisherService;

import javax.validation.Valid;


@Controller
public class PublisherController {

    private final PublisherService publisherService;

    @Autowired
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping("/publishers")
    public String getPublishersPage(Model model, @RequestParam(value = "srt", required = false) String srt) {

        if (srt == null) {
            model.addAttribute("publishers", publisherService.findAll());
        } else if (srt.equals("asc")) {
            model.addAttribute("publishers", publisherService.findAllByOrderByName());
        } else {
            model.addAttribute("publishers", publisherService.findAllByOrderByNameDesc());
        }

        return "publishers";
    }

    @GetMapping("/insert/publisher")
    public String getInsertPublisherPage(PublisherDto publisherDto) {
        return "insert-publisher";
    }

    @PostMapping("/insert/publisher")
    public String insertPublisher(@ModelAttribute @Valid PublisherDto publisherDto, BindingResult result) {
        if (result.hasErrors()) {
            return "insert-publisher";
        } else {
            Publisher newPublisher = new Publisher();

            newPublisher.setName(publisherDto.getName());
            newPublisher.setAddress(publisherDto.getAddress());
            newPublisher.setEmail(publisherDto.getEmail());
            if (publisherDto.getPublisherId() != null) {
                newPublisher.setPublisherId(publisherDto.getPublisherId());
            }

            publisherService.savePublisher(newPublisher);

            return "redirect:/publishers";
        }
    }

    @GetMapping("/publisher/delete")
    public String deletePublisher(@RequestParam("id") long id) throws NotFoundException {
        if (!publisherService.existsById(id)) {
            throw new NotFoundException("Publisher not found");
        } else {
            publisherService.deleteById(id);
        }
        return "redirect:/publishers";
    }

    @GetMapping("/publisher/edit")
    public String editPublisher(@RequestParam("id") long id, PublisherDto publisherDto, Model model) throws NotFoundException {

        if (!publisherService.existsById(id)) {
            throw new NotFoundException("Publisher not found");
        } else {
            Publisher publisher = publisherService.findById(id).get();
            publisherDto.setName(publisher.getName());
            publisherDto.setAddress(publisher.getAddress());
            publisherDto.setEmail(publisher.getEmail());
            publisherDto.setPublisherId(publisher.getPublisherId());
        }

        model.addAttribute(publisherDto);

        return "insert-publisher";
    }
}
