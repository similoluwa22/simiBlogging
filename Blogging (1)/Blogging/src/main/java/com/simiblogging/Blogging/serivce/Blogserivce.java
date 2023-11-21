package com.simiblogging.Blogging.serivce;

import com.simiblogging.Blogging.dto.Blogdto;
import com.simiblogging.Blogging.model.Blog;
import com.simiblogging.Blogging.repository.Blogrepository;
import org.springframework.stereotype.Service;

    @Service
    public class BlogService {

        private final Blogrepository blogrepository;


        public BlogService(Blogrepository blogRepository) {
            this.blogrepository = blogRepository;
        }

        // Create
        public Object createPatient(Blogdto blogdto) {
            Blog blog = new Blog();
            // we map necessary fields
            blog.setTitle(blogdto.getTitle());
            blog.setContent(blogdto.getContent());
            blog.setDatecreated(blogdto.getDatecreated());
            blog.setDateupdated(blogdto.getDateupdated());
            // save the data
            return blogrepository.save(blog);



        }




        // Read
        public Object getBlog(Blogrepository blogrepository, Long id) {
            return blogrepository.findById(id);
        }

        // Update
        public Object updateBlog(Blogdto blogdto, long id) {
            // find our Blog
            Blog blog = blogrepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Blog not found"));


            // update that blog we find
            blog.setTitle(blogdto.getTitle());
            blog.setContent(blogdto.getContent());
            blog.setDatecreated(blogdto.getDatecreated());
            blog.setDateupdated(blogdto.getDateupdated());

            return blogrepository.save(blog);
        }

        // Delete
        public Object deleteblog(long id) {
            Blog  blog = blogrepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Patient not found"));

            blogrepository.delete(blog);
            return "blog has been deleted";
        }
    }


