$(function(){
    $('#save-jig').click(function(){
    let jig = $('.jig-pkc').val();
    let qty = $('.jig-qty').val();
    alert("Data: " + qty + "\nStatus: " + jig);
       $.post('/jigs_add/', {'pkcCode': jig, 'qty': qty} );

//     $("button").click(function(){
//       $.post("demo_test.asp", function(data, status){
//         alert("Data: " + data + "\nStatus: " + status);
//       });
     });
});
