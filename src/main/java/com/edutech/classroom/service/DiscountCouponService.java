package com.edutech.classroom.service;

import com.edutech.classroom.dto.DiscountCouponDTO;
import com.edutech.classroom.entity.DiscountCoupon;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.DiscountCouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class DiscountCouponService {
    private final DiscountCouponRepository discountCouponRepository;

    public List<DiscountCouponDTO> findAll() {
        return discountCouponRepository.findAll().stream().map(DiscountCouponDTO::fromEntity).toList();
    }

    public DiscountCouponDTO findById(Integer id) {
        return DiscountCouponDTO.fromEntity(discountCouponRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cupon de descuento no encontrado")));
    }

    public DiscountCouponDTO create(DiscountCouponDTO dto) {
        return DiscountCouponDTO.fromEntity(discountCouponRepository.save(dto.toEntity()));
    }

    public DiscountCouponDTO update(Integer id,DiscountCouponDTO dto) {
        discountCouponRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cupon de descuento no encontrado"));
        DiscountCoupon entity = dto.toEntity();
        return DiscountCouponDTO.fromEntity(discountCouponRepository.save(entity));
    }

    public void delete(Integer id) {
        discountCouponRepository.delete(discountCouponRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Cupon de descuento no encontrado")));
    }
}
