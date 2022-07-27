package com.example.locationservice.service;


import com.example.locationservice.dto.CommentDto;
import com.example.locationservice.model.Comment;
import com.example.locationservice.model.Ratting;
import com.example.locationservice.repository.CommentRepository;
import com.example.locationservice.repository.RattingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CommentService {
    private CommentRepository commentRepository;
    private RattingRepository rattingRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, RattingRepository rattingRepository) {
        this.commentRepository = commentRepository;
        this.rattingRepository = rattingRepository;
    }


    public List<CommentDto> getAllCommentByLocationID(String location_id) {
        List<Comment> listCmt = commentRepository.findAllByLocationId(location_id);
        List<Ratting> listRatting = rattingRepository.findAllByLocationID(location_id);
        List<CommentDto> rs = new ArrayList<>();

        for (int i = 0; i < listCmt.size(); i++) {
            CommentDto temp = new CommentDto(listCmt.get(i));
            for (int j = 0; j < listRatting.size(); j++) {
                if (listRatting.get(j).create_by.equals(listCmt.get(i).create_by)) {
                    temp.point = listRatting.get(j).pointRating;
                }
            }
            rs.add(temp);
        }
        return rs;
    }

    public Comment addNew(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment update(Comment comment) {
        // test cho TH 1 nguoi chi duoc comment 1 lan
        // cần thêm uniqueId cho comment để xác định duy nhất comment cần sửa mới đúng tính chất của bản comment
        List<Comment> comments = commentRepository.findAllByLocationId(comment.getLocation_id());
        Comment c = comments.stream()
                .filter(cm -> comment.getCreate_by().equals(cm.getCreate_by()))
                .findAny().orElse(null);

        c.content = comment.getContent();

        return commentRepository.save(c);
    }

    public int updateComment(Comment comment) {
        return commentRepository.updateComment(comment.getLocation_id(), comment.getCreate_by(), comment.getContent());
    }
}
