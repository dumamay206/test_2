<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>    
<html>    
<head>    

<meta name="viewport" content="width=device-width, initial-scale=1">    

<script type="text/javascript" src="<%=request.getContextPath()%>/resources/ckeditor/ckeditor.js">
		
	</script>
<style>    
* {    
  box-sizing: border-box;    
}    
    
input[type=text], select, textarea {    
  width: 100%;    
  padding: 12px;    
  border: 1px solid rgb(70, 68, 68);    
  border-radius: 4px;    
  resize: vertical;    
}    
input[type=email], select, textarea {    
  width: 100%;    
  padding: 12px;    
  border: 1px solid rgb(70, 68, 68);    
  border-radius: 4px;    
  resize: vertical;    
}    
    
label {    
  padding: 12px 12px 12px 0;    
  display: inline-block;    
}    
    
input[type=submit] {    
  background-color: rgb(37, 116, 161);    
  color: white;    
  padding: 12px 20px;    
  border: none;    
  border-radius: 4px;    
  cursor: pointer;    
  float: right;    
}    
    
input[type=submit]:hover {    
  background-color: #45a049;    
}    
    
.container {    
  border-radius: 5px;    
  background-color: #f2f2f2;    
  padding: 20px;    
}    
    
.col-25 {    
  float: left;    
  width: 25%;    
  margin-top: 6px;    
}    
    
.col-75 {    
  float: left;    
  width: 75%;    
  margin-top: 6px;    
}    
    
/* Clear floats after the columns */    
.row:after {    
  content: "";    
  display: table;    
  clear: both;    
}    
    
/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */    
</style>    
</head>    
<body>    
<h2>FEED BACK FORM</h2>    
<div class="container">    
<!-- 	user sau nay se la table phieu feedback -->
  <form action="feedback.htm"  modelAttribute="user" method="post" enctype = "multipart/form-data">       
    <div class="row">    
        <div class="col-25">    
          <label for="email">Mail Id</label>    
        </div>    
        <div class="col-75">    
          <input type="email" name="email" placeholder="Your mail id.." required="">    
        </div>    
      </div>       
    <div class="row">    
      <div class="col-25">    
        <label for="feedback">Feed Back</label>    
      </div>    
      <div class="col-75">    
        <textarea id="messagebody" name="feedback" placeholder="Write something.." style="height:200px"></textarea>    
      </div>    
    </div>    
    <div class="row">
    <div class="col-25">    
          <label for="complaint">Khiếu nại(nếu có)</label>    
        </div>  
		<label for="formFile" class="col-sm-2 col-form-label">Chọn
			file hình ảnh khiếu nại</label> <input name="file" class="col-sm-3" type="file"
			id="formFile">
	</div>
	<c:if test="${ not empty message}">
							<div class="row mb-3">
									${message }
							</div>
					</c:if>
    <div class="row">    
      <input type="submit" value="Submit">    
    </div>    
  </form>    
</div>    
    <script>
var editor = CKEDITOR.replace( 'messagebody' );

	
</script>
</body>    
</html>  
