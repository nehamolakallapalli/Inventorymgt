package com.dxctraining.inventorymgt.item.util;

import com.dxctraining.inventorymgt.item.dto.PhoneDto;
import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.item.entities.Phone;
import org.springframework.stereotype.Component;

@Component
public class PhoneUtil {
    public PhoneDto phoneDto(Item phone, int supplierId, String supplierName){
        PhoneDto dto = new PhoneDto(phone.getId(),phone.getName(),((Phone) phone).getStoragesize());
        dto.setSupplierId(supplierId);
        dto.setSupplierName(supplierName);
        return dto;
    }
}