
console.log('Init chat...'+ new Date())

const addInvoice = () => {
    console.log('add invoice ...' + new Date());
    const ct = document.querySelector('#iContent');
    
    fetch("https://0305127353.acconline.vn/invoiceapi.php", {
        method: "POST",
        body: JSON.stringify({
            "api_key": "n9cYd69ayg!oBR1gqVYUkbXSpehcXVdc",
            "ver": "1.1",
            "op": "invoiceapi",
            "act": "invoice",
            "type": "1",
            "id_local": "05MS7M000000094",
            "action": "add_invoice",
            "data": {
                "username": "api_user",
                "password": "hddt@341a",
                "taxCodeDomain": "0305127353",
                "idInvoice": "",
                "invDate": "2023-05-16",
                "cusTaxCode": "0301465224",
                "cusComCode": "GDIN-BVNN-HCM",
                "cusName": "Nguyễn Văn A",
                "cusComName": "BỆNH VIỆN NHÂN DÂN GIA ĐỊNH",
                "cusAddress": "Số 01 Nơ Trang Long, Phường 7, Quận Bình Thạnh, TP. Hồ Chí Minh",
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
        }),
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        }, 
        mode: 'no-cors',
        }).then(response => {
          console.log("res",response)
          return {}
        } ).then(res => {
            ct.innerHTML = JSON.stringify(res, null, 4)
        });
}

async function main () {
    const buttonStart = document.querySelector('#buttonStart')
    const buttonStop = document.querySelector('#buttonStop')
    const videoLive = document.getElementById('videoLive')
    const videoRecorded = document.querySelector('#videoRecorded')

    const stream = await navigator.mediaDevices.getUserMedia({ // <1>
      video: true,
      audio: true,
    })


    console.log('stream', stream   )
    videoLive.srcObject = stream

    if (!MediaRecorder.isTypeSupported('video/webm')) { // <2>
      console.warn('video/webm is not supported')
    }

    const mediaRecorder = new MediaRecorder(stream, { // <3>
      mimeType: 'video/webm',
    })

    buttonStart.addEventListener('click', () => {
      mediaRecorder.start() // <4>
      buttonStart.setAttribute('disabled', '')
      buttonStop.removeAttribute('disabled')
    })

    buttonStop.addEventListener('click', () => {
      mediaRecorder.stop() // <5>
      buttonStart.removeAttribute('disabled')
      buttonStop.setAttribute('disabled', '')
    })

    mediaRecorder.addEventListener('dataavailable', event => {
      videoRecorded.src = URL.createObjectURL(event.data) // <6>
    })
  }

  //main()