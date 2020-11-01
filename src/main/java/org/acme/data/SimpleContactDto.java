package org.acme.data;

import lombok.Value;

@Value
public class SimpleContactDto {

    int contactId;
    
    String companyName;
}
