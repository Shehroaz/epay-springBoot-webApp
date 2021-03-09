const paymentStart = () => {
    console.log("payment start");
    let amount=$("#payment_field").val();
    console.log(amount);
    if (amount === "" || amount === null){
        swal("Failed !!", "Amount is required !!", "error");
        return;
    }

    //we use ajax to to send request to server to create order- jquery
    $.ajax(
        {
            url:'/createOrder',
            data:JSON.stringify({amount:amount , info: 'order_request'}),
            contentType:'application/json',
            type:'POST',
            dataType:'json',
            success:function (response){
                //invoked when success
                console.log(response);
                if (response.status === "created"){
                    //open payment form
                    let options = {
                        key:'rzp_test_Qncr2klHRUuEHA',
                        amount: response.amount,
                        currency:'INR',
                        name:'epayDigital',
                        description:'checking payment gateway',
                        image:'/images/logo.png',
                        order_id:response.id,
                        handler :function (response){
                            console.log(response.razorpay_payment_id);
                            console.log(response.razorpay_order_id);
                            console.log(response.razorpay_signature);
                            console.log("payment successful")
                             // alert("congrats payment is successful");
                            swal("Good job!", "congrats payment is successful", "success");

                        },
                        prefill: {
                            name : "",
                            email: "",
                            contact:"",
                        },
                        "notes" : {
                            "address" : "EpayDigital client"
                        },
                        theme: {
                            color: "#3399cc",
                        },
                    };
                    let rzp = new Razorpay(options);
                    rzp.on('payment.failed', function (response) {
                        console.log(response.error.code);
                        console.log(response.error.description);
                        console.log(response.error.source);
                        console.log(response.error.step);
                        console.log(response.error.reason);
                        console.log(response.error.metadata.order_id);
                        console.log(response.error.metadata.payment_id);
                        // alert("oops payment failed something wrong")
                        swal("Failed !!", "oops payment failed something wrong", "error");

                    });



                    rzp.open();
                }
            },
            error:function (error){
                //invoked when error
                console.log(error);
                alert("something went wrong !!");
            }
        }
    )
};