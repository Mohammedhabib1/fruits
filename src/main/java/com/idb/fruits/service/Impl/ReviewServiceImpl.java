package com.idb.fruits.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idb.fruits.model.Review;
import com.idb.fruits.repository.ReviewRepository;
import com.idb.fruits.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Optional<Review> findById(Long id) {
    return reviewRepository.findById(id);
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }
}