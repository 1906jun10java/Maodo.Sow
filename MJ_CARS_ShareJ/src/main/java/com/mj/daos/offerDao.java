package com.mj.daos;

import java.util.List;

import com.mj.users.CustomerOffer;

public interface offerDao {
		
		public void createOffer(CustomerOffer customerOffer);
		public void updateRejected(int offerId);
		public void updateAccepted(int offerId);
		public List<CustomerOffer> getAllPendingCarOffers(int carId);
		public CustomerOffer getOfferById(int offerId);
		public List<CustomerOffer> getAllPendingOffers();
	}

