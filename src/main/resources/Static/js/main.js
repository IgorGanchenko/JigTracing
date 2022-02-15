$(function(){
    $('#save-jig').click(function(){
            let jig = $('.jig-pkc').val();
            let qty = $('.jig-qty').val();
            alert("Data: " + qty + "\nStatus: " + jig);
               $.post('/jigs/', {'pkcCode': jig, 'qty': qty} );
             });

    $('#delete-jig').click(function(){
             let jig = $('.jig-pkc').val();
             $.ajax({
                 url: '/jigs/?pkcCode=' + jig,
                 type: 'DELETE',
                 success: alert("Delete: "  + jig)
             });
    });
});
