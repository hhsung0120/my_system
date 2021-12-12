package io.system.heeseong.common.domain.model;

import io.system.heeseong.common.code.CommonCode;
import io.system.heeseong.common.code.EnumModel;
import lombok.Getter;

import java.util.Arrays;
import java.util.stream.Collectors;

@Getter
public class ResponseData {

    private String code;
    private String message;
    private Object data;

    public ResponseData() {

    }

    public ResponseData(Class<? extends EnumModel> e) {
        Arrays.stream(e.getEnumConstants()).map(ResponseData::new)
                .collect(Collectors.toList());

        //new ResponseData(commonCode, null);
    }


    public ResponseData(EnumModel enumModel) {
        System.out.println(enumModel.getKey());
        System.out.println(enumModel.getValue());
    }

    public ResponseData(CommonCode commonCode, Object data) {
        this.code = commonCode.getCode();
        this.message = commonCode.getValue();
        this.data = data;
    }

}
