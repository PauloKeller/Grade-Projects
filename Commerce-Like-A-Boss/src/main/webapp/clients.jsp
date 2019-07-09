<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="commun/header.jsp"/>
<section>
	<center>
		<div class="title-container">
			<h1>MY CLIENTS</h1>
		</div>
	</center>
	
	<div class="clients-container">
		<% for(int i = 0; i < 20; i+=1) { %>
		
			<div class="client-container">
			
				<div class="client-image-container">
					<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVqOAV_EarSlLIJ02tCjjdHtoNkQc8EVDNnsf6fKO-3NZoEMeZ" alt="client image">
				</div>
				
				<div class="client-info-container">
					<p>Name:</p>
					<p>Cel:</p>
					<p>Email:</p>
					<p>Age:</p>
					<p>Country:</p>
				</div>
				
				<div class="client-info-container">
					<p>City:</p>
					<p>State:</p>
					<p>District:</p>
					<p>Street:</p>
					<p>Number:</p>
				</div>
				 
			</div>
		
		<% } %>
		
	</div>
	

</section>

<jsp:include page="commun/footer.jsp"/>