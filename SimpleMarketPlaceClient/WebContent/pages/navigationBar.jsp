
<%@page import="com.amazon.dto.CategoryDTO"%>

<%
	if (request.getAttribute("selectedCategory") == null) {
		request.setAttribute("selectedCategory", "All Categories");
	}
	if (request.getAttribute("cartItemCount") == null) {
		request.setAttribute("cartItemCount", "0");
	}
	
	%>
<script>
var CONTEXT_PATH = "<%=request.getContextPath()%>";

</script>

<div role="navigation" class="navbar navbar-inverse navbar-static-top">
	<div class="container">
		<div class="navbar-header"></div>
		<button type="button" data-toggle="collapse" data-target=".navbar-collapse" class="navbar-toggle">
			<span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span
				class="icon-bar"
			></span>
		</button>
		<a href="#" class="navbar-brand" style="margin-top: -8px;"><img
			src="<%=request.getContextPath()%>/images/bag-icon.png"
		/> Simple Market Place</a>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<%
					if (userName.equalsIgnoreCase("Guest")) {
						if (pageOf == "signIn") {
				%>
				<li><a href="<%=request.getContextPath()%>/SignUp.do">Sign Up</a></li>
				<%
					} else if (pageOf == "signUp") {
				%>
				<li><a href="<%=request.getContextPath()%>/Login.do">Sign In</a></li>
				<%
					}
					}
				%>
			</ul>
			<%
				if (!userName.equalsIgnoreCase("Guest")) {
			%>
			<ul class="nav navbar-nav navbar-left">
				<li><a href="<%=request.getContextPath()%>/Product.do">Add Product</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-left">
				<li><a href="<%=request.getContextPath()%>/Category.do">Add Category</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-left">
				<li style="margin: 10px 20px 0px 10px">
					<div class="btn-group">
						<button class="btn btn-info dropdown-toggle" type='button' data-toggle='dropdown' id='categoryDropdown'>
							<%=request.getAttribute("selectedCategory")%>
							<span class="caret"> </span>
						</button>
						<ul class="dropdown-menu" role='menu'>
							<%
								CategoryDTO[] categories = ((CategoryDTO[]) session.getAttribute("categories"));
									if (categories != null) {
										for (int j = 0; j < categories.length; j++) {
											CategoryDTO category = categories[j];
							%>
							<li><a onclick="dropdownHandling(this)" id="<%=category.getIdentifier()%>"><%=category.getCategoryName()%></a></li>
							<%
								}
									}
							%>
						</ul>
					</div>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="<%=request.getContextPath()%>/Logout.do">Logout</a></li>
			</ul>
			<%
				}
			%>
			<ul class="nav navbar-nav  navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<div>
							<p>
								Welcome,
								<%=userName%>
								<b class="caret"></br> <label style="margin-top: -12px; margin-left: -120px; font-size: 11px;"><%=lastLoginTime%></label></b>
							</p>
						</div>
				</a>
					<ul class="dropdown-menu">
						<li><a href="<%=request.getContextPath()%>/History.do">My History</a></li>
					</ul></li>
			</ul>
			<%
				if (!userName.equalsIgnoreCase("Guest")) {
			%>
			<ul class="nav navbar-nav navbar-right">
				<li style="margin: 10px">
					<button class="btn btn-success btn-sm" id="checkout"
						onclick="javascript:window.location.href='<%=request.getContextPath()%>/ShoppingCart.do'"
					>Checkout</button>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="cartCountStyle"><a>CART : <label id="cartItemCount"><%=request.getAttribute("cartItemCount")%></label></a></li>
			</ul>
			<%
				}
			%>
		</div>
	</div>
</div>