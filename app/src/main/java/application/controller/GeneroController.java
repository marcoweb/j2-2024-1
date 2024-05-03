package application.controller;

import application.model.Genero;
import application.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller 
@RequestMapping("/genero")
public class GeneroController {

    @Autowired
    private GeneroRepository generoRepo;

    @RequestMapping("/list")
    public String list(Model ui) {
        ui.addAttribute("generos", generoRepo.findAll());
        return "/genero/list";
    }

    @RequestMapping("/insert")
    public String insertForm() {
        return "/genero/insert"; 
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestParam("nome") String nome) {
        Genero genero = new Genero();
        genero.setNome(nome);
        generoRepo.save(genero);
        return "redirect:/genero/list";
    }

    @RequestMapping("/update/{id}")
    public String updateForm(Model ui, @PathVariable long id){
        Optional<Genero> resultado = generoRepo.findById(id);
        if(resultado.isPresent()) {
            ui.addAttribute("genero", resultado.get());
            return "/genero/update";
        }
        return "redirect:/genero/list";
    }

    @RequestMapping(value= "/update", method = RequestMethod.POST)
    public String update(@RequestParam("id") long id,
                         @RequestParam("nome") String nome ){
        Optional<Genero> resultado = generoRepo.findById(id);
        if(resultado.isPresent()) {
            Genero genero = resultado.get();
            genero.setNome(nome);
            generoRepo.save(genero);
        }
        return "redirect:/genero/list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteForm(Model ui, @PathVariable long id){
        Optional<Genero> resultado = generoRepo.findById(id);
        if(resultado.isPresent()) {
            ui.addAttribute("genero", resultado.get());
            return "/genero/delete";
        }
        return "redirect:/genero/list";
    }

    @RequestMapping(value = "/delete", method= RequestMethod.POST)
    public String delete(@RequestParam("id") long id) {
        generoRepo.deleteById(id);
        return "redirect:/genero/list";
    }
}
