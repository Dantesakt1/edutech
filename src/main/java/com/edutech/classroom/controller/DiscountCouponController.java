package com.edutech.classroom.controller;

import com.edutech.classroom.dto.DiscountCouponDTO;
import com.edutech.classroom.service.DiscountCouponService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/discount-coupons")
@RequiredArgsConstructor

public class DiscountCouponController {
    private final DiscountCouponService discountCouponService;

    @GetMapping
    public ResponseEntity<List<DiscountCouponDTO>> findAll() {
        return ResponseEntity.ok(discountCouponService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiscountCouponDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(discountCouponService.findById(id));
    }

    @PostMapping
    public ResponseEntity<DiscountCouponDTO> create(@RequestBody @Valid DiscountCouponDTO dto) {
        return ResponseEntity.ok(discountCouponService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiscountCouponDTO> update(@PathVariable Integer id, @Valid @RequestBody DiscountCouponDTO dto) {
        return ResponseEntity.ok(discountCouponService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        discountCouponService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
