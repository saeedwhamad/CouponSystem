package Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import beans.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

}
