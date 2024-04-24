package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Livro;
import application.repository.LivroRepository;

@Controller 
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroRepository livroRepo;

    @RequestMapping("/list")
    public String list(Model ui) {
        // Livro[] livros = new Livro[2];
        // livros[0] = new Livro();
        // livros[0].setId(1);
        // livros[0].setTitulo("Percy Jackson e o Prisioneiro de Askaban");
        // livros[0].setGenero("Aventura/Fantasia");
        // livros[1] = new Livro();
        // livros[1].setId(2);
        // livros[1].setTitulo("Harry Potter e a Pedra Filosofal");
        // livros[1].setGenero("Alta Fantasia");
    
        ui.addAttribute("livros", livroRepo.findAll());
    
        return "/livros/list";
    
    }

    @RequestMapping("/insert")
    public String insert() {
        return "/livros/insert"; 
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(
        @RequestParam("titulo") String titulo,
        @RequestParam("genero") String genero) {
        
            Livro livro = new Livro();
            livro.setTitulo(titulo);
            livro.setGenero(genero);

            livroRepo.save(livro);

        return "redirect:/livros/list";
    }

    @RequestMapping("/update/{id}")
    public String update(Model ui, @PathVariable long id){
        Optional<Livro> resultado = livroRepo.findById(id);

        if(resultado.isPresent()) {
            ui.addAttribute("livro", resultado.get());
            return "/livros/update";
        }

        return "redirect:/livros/list";
    }

}