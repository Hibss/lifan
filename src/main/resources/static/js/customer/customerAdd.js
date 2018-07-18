function saveCustomer(){
    var name= $('#name').val(),code=$('#code').val(),mobile=$('#mobile').val();
    $.ajax({
        url : "/customer/save",
        contentType: "application/json",
        type : "POST",
        data:JSON.stringify({
            name : name,
            code : code,
            mobile :mobile
        }),
        success : function(data) {

        }
    });
}

$('.btn').on('click',saveCustomer);