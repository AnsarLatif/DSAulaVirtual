package com.aguilarpgc.aulamatrix.logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aguilarpgc.aulamatrix.model.BillDetail;
import com.aguilarpgc.aulamatrix.repository.BillDetailRepository;

@Service
public class ManageBillDetailLogic {
	@Autowired
	private BillDetailRepository billDetailRepository;
	
	public BillDetail getBillDetail(Integer id){
		return billDetailRepository.getBillDetail(id);
	}
	
	public void delBillDetail(Integer idBillDetail){
		if(idBillDetail !=null){
			BillDetail billDetail = getBillDetail(idBillDetail);
			if(billDetail!=null){
				billDetailRepository.deleteBillDetail(billDetail);
			}
		}
	}
}
