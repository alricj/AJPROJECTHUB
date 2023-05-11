$(function() {
    $(document).ready(function() {
       // $("#table_id").DataTable({"pageLength": 3});

        $('#table_id').dataTable( {
            "pageLength": 3,
            "aLengthMenu": [[5, 10, 20, 30, -1], [10, 25, 50, 100, "All"]],
             "iDisplayLength": 10
        } );

        function loadData() {
            var protocol = window.location.protocol;
            var host = window.location.host;
            var port = window.location.port;
            var _url = protocol+"//"+host+"/api/alluser";;
            $.ajax({
                type: 'GET',
                url: _url,
                contentType: "text/plain",
                dataType: 'json',
                success: function(data) {
                    userData = data;
                    populateDataTable(userData);
                },
                error: function(e) {
                    console.log("There was an error with your request...");
                    console.log("error: " + JSON.stringify(e));
                }
            });
        }

        function populateDataTable(data) {
            // clear the table before populating it with more data
            $("#table_id").DataTable().clear();
            var length = Object.keys(data).length;
            for (var i = 0; i < length; i++) {
                var user = data[i];
                // You could also use an ajax property on the data table initialization
                $("#table_id").dataTable().fnAddData([
                    user.id,
                    user.email,
                    user.firstname,
                    user.lastname,
                    user.avatar
                ]);
            }
        }
        // here the data is loaded in the table
        loadData();

    });

});
