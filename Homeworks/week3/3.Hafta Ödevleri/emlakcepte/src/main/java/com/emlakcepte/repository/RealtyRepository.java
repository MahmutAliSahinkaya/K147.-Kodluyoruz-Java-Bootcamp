package com.emlakcepte.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.emlakcepte.model.Realty;

@Repository
public class RealtyRepository {

	private static List<Realty> realties = new ArrayList<>();

	public void save(Realty realty) {
		realties.add(realty);
	}

	public List<Realty> findAll() {
		return realties;
	}

	public Realty findByNo(Long no) {
		for (Realty realty : realties) {
			if (realty.getNo().equals(no)) {
				return realty;
			}
		}
		return null;
	}

	public void delete(Realty realty) {
		realties.remove(realty);
	}
}