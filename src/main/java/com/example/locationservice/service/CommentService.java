package com.example.locationservice.service;


import com.example.locationservice.model.Comment;
import com.example.locationservice.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentService {
    private CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getAllCommentByLocationID(String location_id) {
        return commentRepository.findAllByLocationId(location_id);
    }

    public Comment addNew(Comment comment) {
        return commentRepository.save(comment);
    }

    public  Comment update(Comment comment){
        // test cho TH 1 nguoi chi duoc comment 1 lan
        // cần thêm uniqueId cho comment để xác định duy nhất comment cần sửa mới đúng tính chất của bản comment
        List<Comment> comments = commentRepository.findAllByLocationId(comment.getLocation_id());
        Comment c = comments.stream()
                .filter(cm -> comment.getCreate_by().equals(cm.getCreate_by()))
                .findAny().orElse(null);

        c.content = comment.getContent();

        return  commentRepository.save(c);
    }
    public int updateComment(Comment comment){
        return commentRepository.updateComment(comment.getLocation_id(), comment.getCreate_by(), comment.getContent());
    }
}
