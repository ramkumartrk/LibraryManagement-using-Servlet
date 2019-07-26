
alert('ramkumar');
	$(document).ready(function() {
		 //On Button Click

		alert('ready working ramkumar');
		 $("#submit").click(function() {

			
			 alert('click working ramkumar');
	
			 
		 var bookid = $("bookid").val();
			 //Get Text box values
		 var  book = $("#bookname").val();
		 var author = $("#authorname").val();
		 var publication = $("#publication").val();
		 console.log(bookid +' ' +  book + ' ' + author + ' ' + publication);
		 $.ajax({
			
		 url : './EditBook2?bookid='+bookid+"&book="+book+"&author="+author+"&publication="+publication,
		 dataType : "json",
		 type : "POST",
		 
		 success : function(result) {
		 			$("#message").text(result);
		 
		 			
		 $("#book").val('');
		 $("#author").val('');
		 $("#publication").val('');
		 },
		 
		 error : function(responseText) {
		 alert("error");
		    }
		 
		 });
		 
		 });
		 
		});

	
