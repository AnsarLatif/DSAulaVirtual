package com.aguilarpgc.aulamatrix.repository;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aguilarpgc.aulamatrix.model.Bill;
import com.aguilarpgc.aulamatrix.model.BillDetail;

@Repository
@Transactional
public class BillDetailRepository extends HibernateRepository{
	
	public BillDetail getBillDetail(Integer id){
		return (BillDetail) getSession().get(BillDetail.class, id);
	}		
	
	public void deleteBillDetail(BillDetail detail){
		getSession().delete(detail);
	}
}
