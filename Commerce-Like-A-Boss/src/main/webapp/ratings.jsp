<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="commun/header.jsp"/>
<section>
	<center>
		<div class="title-container">
			<h1>MY RATINGS</h1>
		</div>
	</center>
	
	<div class="ratings-container">
		<% for(int i = 0; i < 20; i+=1) { %>
		
			<div class="rating-container">
			
				<div class="rating-image-container">
					<img src="https://images.vexels.com/media/users/3/143047/isolated/preview/b0c9678466af11dd45a62163bdcf03fe-fast-food-hamburger-flat-icon-by-vexels.png">
				</div>
				
				<div class="rating-info-container">
					<p>Client Name:</p>
					<p>Email:</p>
					<p>Stars:</p>
					<p>Comment:</p>
				</div>
				 
			</div>
		
		<% } %>
		
	</div>
	

</section>

<jsp:include page="commun/footer.jsp"/>