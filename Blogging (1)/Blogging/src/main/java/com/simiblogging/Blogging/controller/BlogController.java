package com.simiblogging.Blogging.controller;
import com.simiblogging.Blogging.dto.Blogdto;
import com.simiblogging.Blogging.model.Blog;
import com.simiblogging.Blogging.dto.Blogdto;
import com.simiblogging.Blogging.serivce.BlogService;
import org.springframework.web.bind.annotation.*;


    @RestController
    @RequestMapping("/api")
    public class BlogController {

        private final BlogController BlogService;

        public BlogController(BlogController BlogService) {
            this.BlogService = BlogService;
        }

        @PostMapping("/Blog/create")
        public Object createBlog(@RequestBody  BlogController Blogdto) {
            return BlogService.createBlog(Blogdto);

        }
        @GetMapping("/Blog")
        public Object getBlog() {
            return BlogService.getBlog();
        }


        @PutMapping("Blog/{id}")
        public Object updateBlog(@RequestBody Blogdto blogDto, @PathVariable long id) {
            return BlogService.updateBlog(blogDto, id);
        }


        @DeleteMapping("/Blog/{id}")
        public Object deleteBlog(@PathVariable long id) {
            return BlogService.deleteBlog(id);
        }
    }

