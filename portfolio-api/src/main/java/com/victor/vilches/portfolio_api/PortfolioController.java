package com.victor.vilches.portfolio_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Controller för att hantera CRUD-operationer för Portfolio-data (projekt, blogginlägg, kontaktinformation).
 * Inkluderar stöd för GitHub-länkar och indikation på om ett projekt är Spring Boot-baserat.
 */
@RestController
@RequestMapping("/api")
public class PortfolioController {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private BlogPostRepository blogPostRepository;
    @Autowired
    private ContactInfoRepository contactInfoRepository;

    // Projects CRUD

    /**
     * Hämta alla projekt.
     * @return Lista över alla projekt.
     */
    @GetMapping("/projects")
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    /**
     * Hämta ett specifikt projekt baserat på ID.
     * @param id Projektets ID.
     * @return Projektet om det finns, annars 404.
     */
    @GetMapping("/projects/{id}")
    public Project getProject(@PathVariable Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Projekt med ID " + id + " hittades inte"));
    }

    /**
     * Lägg till ett nytt projekt, inklusive GitHub-länk och Spring Boot-flagg.
     * @param project Projektet att lägga till.
     * @return Det sparade projektet.
     */
    @PostMapping("/projects")
    @ResponseStatus(HttpStatus.CREATED)
    public Project addProject(@RequestBody Project project) {
        return projectRepository.save(project);
    }

    /**
     * Uppdatera ett befintligt projekt, inklusive GitHub-länk och Spring Boot-flagg.
     * @param id Projektets ID.
     * @param project Uppdaterad projektinformation.
     * @return Det uppdaterade projektet.
     */
    @PutMapping("/projects/{id}")
    public Project updateProject(@PathVariable Long id, @RequestBody Project project) {
        if (!projectRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Projekt med ID " + id + " hittades inte");
        }
        project.setId(id);
        return projectRepository.save(project);
    }

    /**
     * Ta bort ett projekt baserat på ID.
     * @param id Projektets ID.
     */
    @DeleteMapping("/projects/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProject(@PathVariable Long id) {
        if (!projectRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Projekt med ID " + id + " hittades inte");
        }
        projectRepository.deleteById(id);
    }

    /**
     * Hämta alla projekt som är byggda med Spring Boot.
     * @return Lista över Spring Boot-projekt.
     */
    @GetMapping("/projects/spring-boot")
    public List<Project> getAllSpringBootProjects() {
        return projectRepository.findAllSpringBootProjects();
    }

    // Blog Posts CRUD (ingen ändring här, eftersom vi inte påverkar blogginlägg)

    /**
     * Hämta alla blogginlägg.
     * @return Lista över alla blogginlägg.
     */
    @GetMapping("/blogposts")
    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    /**
     * Hämta ett specifikt blogginlägg baserat på ID.
     * @param id Blogginläggets ID.
     * @return Blogginlägget om det finns, annars 404.
     */
    @GetMapping("/blogposts/{id}")
    public BlogPost getBlogPost(@PathVariable Long id) {
        return blogPostRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Blogginlägg med ID " + id + " hittades inte"));
    }

    /**
     * Lägg till ett nytt blogginlägg.
     * @param blogPost Blogginlägget att lägga till.
     * @return Det sparade blogginlägget.
     */
    @PostMapping("/blogposts")
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost addBlogPost(@RequestBody BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }

    /**
     * Uppdatera ett befintligt blogginlägg.
     * @param id Blogginläggets ID.
     * @param blogPost Uppdaterad blogginformation.
     * @return Det uppdaterade blogginlägget.
     */
    @PutMapping("/blogposts/{id}")
    public BlogPost updateBlogPost(@PathVariable Long id, @RequestBody BlogPost blogPost) {
        if (!blogPostRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Blogginlägg med ID " + id + " hittades inte");
        }
        blogPost.setId(id);
        return blogPostRepository.save(blogPost);
    }

    /**
     * Ta bort ett blogginlägg baserat på ID.
     * @param id Blogginläggets ID.
     */
    @DeleteMapping("/blogposts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBlogPost(@PathVariable Long id) {
        if (!blogPostRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Blogginlägg med ID " + id + " hittades inte");
        }
        blogPostRepository.deleteById(id);
    }

    // Contact Info CRUD (ingen ändring här, eftersom vi inte påverkar kontaktinformation)

    /**
     * Hämta all kontaktinformation.
     * @return Lista över all kontaktinformation.
     */
    @GetMapping("/contact")
    public List<ContactInfo> getAllContactInfo() {
        return contactInfoRepository.findAll();
    }

    /**
     * Hämta specifik kontaktinformation baserat på ID.
     * @param id Kontaktens ID.
     * @return Kontaktinformationen om den finns, annars 404.
     */
    @GetMapping("/contact/{id}")
    public ContactInfo getContactInfo(@PathVariable Long id) {
        return contactInfoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Kontaktinformation med ID " + id + " hittades inte"));
    }

    /**
     * Lägg till ny kontaktinformation.
     * @param contactInfo Kontaktinformationen att lägga till.
     * @return Den sparade kontaktinformationen.
     */
    @PostMapping("/contact")
    @ResponseStatus(HttpStatus.CREATED)
    public ContactInfo addContactInfo(@RequestBody ContactInfo contactInfo) {
        return contactInfoRepository.save(contactInfo);
    }

    /**
     * Uppdatera befintlig kontaktinformation.
     * @param id Kontaktens ID.
     * @param contactInfo Uppdaterad kontaktinformation.
     * @return Den uppdaterade kontaktinformationen.
     */
    @PutMapping("/contact/{id}")
    public ContactInfo updateContactInfo(@PathVariable Long id, @RequestBody ContactInfo contactInfo) {
        if (!contactInfoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Kontaktinformation med ID " + id + " hittades inte");
        }
        contactInfo.setId(id);
        return contactInfoRepository.save(contactInfo);
    }

    /**
     * Ta bort kontaktinformation baserat på ID.
     * @param id Kontaktens ID.
     */
    @DeleteMapping("/contact/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContactInfo(@PathVariable Long id) {
        if (!contactInfoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Kontaktinformation med ID " + id + " hittades inte");
        }
        contactInfoRepository.deleteById(id);
    }
}