package vn.code.skycloud.controllers;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Controller
public class InvoiceController {

    @GetMapping(path = "/add")
    public String addInvoice() throws IOException {

        String jsonBody = """
                {
                    "api_key": "fdsfas!dsfas",
                    "ver": "1.1",
                    "op": "invoiceapi",
                    "act": "invoice",
                    "type": "1",
                    "id_local": "05MS7M000000094",
                    "action": "add_invoice",
                    "data": {
                        "username": "weqr",
                        "password": "weqrqw@erw",
                        "taxCodeDomain": "0305127353",
                        "idInvoice": "",
                        "invDate": "2023-05-16",
                        "cusTaxCode": "0301465224",
                        "cusComCode": "GDIN-BVNN-HCM",
                        "cusName": "Nguyễn Văn A",
                        "cusComName": "BỆNH VIỆsfadfN NHÂN DsadfasÂN GIA ĐỊNH",
                        "cusAddress": "Số 01 dsfNơ Trang Long, Phường 7, Quận Bình Thạnh, TP. Hồ Chí Minh",
                        "cusEmail": "giadinh@gmail.com",
                        "cusBankNumber": "1122334455",
                        "invPayMethod": "CK",
                        "invCurrency": "",
                        "invRate": "10.0000",
                        "invSubTotal": 200000.0,
                        "invVat": "10",
                        "invVatAmount": "20000.00000000",
                        "invTotalAmount": "220000.00000000",
                        "invTotalAmountInWord": "Một trăm mười ngàn đồng",
                        "listProduct": [
                            {
                                "sku": "SX-H-2300-1001-W",
                                "code": "SX-H-2300",
                                "name": "Cán kẹp/clip",
                                "unit": "Bộ",
                                "quantity": "1",
                                "quantity_in": "0",
                                "quantity_out": "0",
                                "price": "100000.0",
                                "intomoney": 100000,
                                "vatper": "10",
                                "tienthue": 10000.0,
                                "thanhtiensauthue": 110000.0
                            },
                            {
                                "sku": "FS-OA-10-S",
                                "code": "FS-OA-10",
                                "name": "PLASTIC STENTS, FUSION",
                                "unit": "Cái",
                                "quantity": "1",
                                "quantity_in": "0",
                                "quantity_out": "0",
                                "price": "100000.0",
                                "intomoney": 100000,
                                "vatper": "10",
                                "tienthue": 10000.0,
                                "thanhtiensauthue": 110000.0
                            }
                        ],
                        "wareOut": "",
                        "wareIn": "",
                        "companyConsig": "",
                        "contractNumber": "",
                        "commandManeu": "",
                        "commandName": "",
                        "commandDate": "",
                        "commandReason": "",
                        "shipName": "",
                        "shipVehicle": ""
                    }
                }
                    """;

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(jsonBody, mediaType);
        Request request = new Request.Builder()
                .url("https://sdfasd.sdaf.vn/invoiceapi.php")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();

        System.out.println("KQ:" + response.body().string());
        return "index";
    }
}
