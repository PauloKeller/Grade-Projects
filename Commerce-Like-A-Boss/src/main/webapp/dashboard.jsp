<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="services.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="commun/header.jsp"/>

<section>
	<center>
		<div class="title-container">
			<h1>MOST LOYAL CLIENTS</h1>
		</div>
		<div class="loyal-clients-container">
			<% for(int i = 0; i < 3; i+=1) { %>
				<div class="loyal-client-container">
					<h3>Top Client 1</h3>
					<div>
						<div class="loyal-client-image-container">
							<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVqOAV_EarSlLIJ02tCjjdHtoNkQc8EVDNnsf6fKO-3NZoEMeZ" alt="client image">
						</div>
						<div class="loyal-client-info-container">
							<p> name: <%= test.hello() %> </p>
							<p> tel: xxxxx-xxxx </p>
							<p> email: example@example.com </p>
						</div>			
					</div>
				</div>
			<% } %>
		</div>
		
		<div class="title-container">
			<h1>YOUR TOP RATINGS</h1>
		</div>
		
		<div class="top-ratings-container">
			<% for(int i = 0; i < 8; i+=1) { %>
				<div class="top-rating-container">
					<div class="top-rating-product-image-container">
						<img src="https://images.vexels.com/media/users/3/143047/isolated/preview/b0c9678466af11dd45a62163bdcf03fe-fast-food-hamburger-flat-icon-by-vexels.png" alt="product image"> 
					</div>
					<div class="top-rating-info-container">
						<p>Client Name:</p>
						<p>Email:</p>
						<p>Stars:</p>
						<p>Comment:</p>
					</div>
				</div>
			 <% } %>
		</div>
		
		<div class="title-container">
			<h1>HOW GOOD YOU ARE</h1>
		</div>
		
		<p>graficos</p>
	</center>
</section>

<jsp:include page="commun/footer.jsp"/>