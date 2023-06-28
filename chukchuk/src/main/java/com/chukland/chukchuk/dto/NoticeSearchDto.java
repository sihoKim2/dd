package com.chukland.chukchuk.dto;

import com.chukland.chukchuk.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeSearchDto {
    private String searchDataType;

    private ItemSellStatus searchSellStatus;

    private String searchBy;

    private String searchQuery="";
}
