package com.hicap.springbatch;

import com.hicap.springbatch.model.RetailerDetails;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class RetailerDetailsFieldSetMapper implements FieldSetMapper<RetailerDetails>{

	@Override
	public RetailerDetails mapFieldSet(FieldSet fieldSet) throws BindException {
		RetailerDetails result = new RetailerDetails();
		result.setRetailerId(fieldSet.readInt(0));
		result.setRetailerName(fieldSet.readString(1));
		result.setRetailerLocation(fieldSet.readString(2));
		return result;
	}

}
