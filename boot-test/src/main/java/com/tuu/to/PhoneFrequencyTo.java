package com.tuu.to;

import com.sun.corba.se.spi.ior.ObjectId;
import org.springframework.data.annotation.Id;

public class PhoneFrequencyTo {
    @Id
    private ObjectId id;
    private String time;
    private Long accountId;
    private Long subAccountId;
    private String messageType;
    private String productType;
    private String phone;
}
