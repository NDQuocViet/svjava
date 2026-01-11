/**
 * 
 */

CLIENT_ID = 'trusted-app';
CLIENT_SECRET = 'RnD@APRServer_2020_SecretKey_OAuthe2_JWT';

// Các web-services cần gọi:
SERVICE_END_POINT = 'http://localhost:9090/springmvc/'; 
TOKEN_END_POINT = 'http://localhost:9090/springmvc/'; 
API_END_POINT = 'http://localhost:9090/springmvc/aprserer/'; 
REPORT_END_POINT = 'http://localhost:8080/EPS.TSC.Report/ReportViewer/';

/**
 * Các service-actions sẽ dùng để thao tác dữ liệu, 
 * các service-action này đều được gọi nối tiếp với 
 * SERVICE_END_POINT = 'http://localhost:9090/aprserver/'
 */
SERVICE_ACTION_USER_LIST = 'rest/customers'; 
SERVICE_ACTION_USER_CREATE = 'rest/customer/create'; 
SERVICE_ACTION_USER_INFO = 'rest/customer/{userId}'; 
SERVICE_ACTION_USER_EDIT = 'userManager/user/add'; 
SERVICE_ACTION_USER_DELETE = 'userManager/user/delete/';

SERVICE_ACTION_ROLE_LIST = 'api/roles';

// Các dữ liệu sẽ được lưu trữ vào LocalStorage phục vụ cho việc sử dụng lại sau này:
JWT_ACCESS_TOKEN_KEY = 'AccessToken'; 
JWT_TOKEN_TYPE = 'JWT_TokenType'; 
JWT_TOKEN_ATVALUE = 'JWT_TokenValue'; 
JWT_OBJECT = "JWT_JSON_Object"; 
REFRESH_TOKEN ='refresh_token';

//Ajax variable:
pageIndexModel = null;
totalPages = 0;
currentPage = 1;
maxRecords = 10;
requestURL = null;

// Popup variable:
masID = "masLayer";

// Proess for events: mouseOver and mouseOut in td of table:
currentColor = "";
currentRow = null;

$(document).on("mouseenter", "tr", function(){
	currentColor = $(this).css("background-color");
	currentRow = $(this);
	$(this).css("background-color", "gray");
	$(this).addClass("selectedRow");
});

$(document).on("mouseleave", "tr", function(){
	$(this).css("background-color", "white");
	$(this).removeClass("selectedRow");
	$(currentRow).css("background-color", currentColor);
});

// Open Popup
function openPopup(){
	//$("#productForm").show(600);
	//$("#productForm").toggle(600);
	//$("#productForm").slideToggle();
	$("#productForm").animate({left: '300px', top: '100px'});
	$("#productForm").slideDown(500);
	$("#productForm").css("z-index", "1000");
	//$("#productForm").fadeToggle(800);
	
	var layer = document.createElement("div");
	layer.setAttribute("id", masID);
	$(layer).css("position", "absolute");
	$(layer).animate({left: '0px', top: '0px'});
	$(layer).css("width", "100%");
	$(layer).css("height", "100%");
	$(layer).css("background-color", "gray");
	$(layer).css("z-index", "500");
	$(layer).css("opacity", "0.25");
	document.body.append(layer);
}

// Close popup
function closePopup(){
	//$("#productForm").hide(500);
	//$("#productForm").slideUp();
	$("#productForm").fadeOut(500);
	var layer = document.getElementById(masID);
	document.body.removeChild(layer);
}


// call service to get data
function callService(curPage){
	currentPage = curPage;
	//var StoJWT = localStorage.getItem(JWT_ACCESS_TOKEN_KEY); 
	var requestURL = SERVICE_END_POINT + SERVICE_ACTION_USER_LIST + "/" + 
						currentPage + "/" + maxRecords;
	$.ajax({
		url : requestURL, 
		type : 'GET',
		crossDomain: true,
		dataType: 'json',
		success : function(data) {
			processData(data);
		},
		error : function(e) {
			alert(e + '-->' + e.responseText);
		}
	});
}

function processData(data){
	pageIndexModel = data;
	// update paging
	$("#pageIndex_pages").text(pageIndexModel.currentPage + " / " + pageIndexModel.totalPages);
	totalPages = pageIndexModel.totalPages;
	currentPage = pageIndexModel.currentPage;
	
	// update data for table
	$('#userTable tbody').empty();
	count = (currentPage - 1) * maxRecords + 1;
	$.each(pageIndexModel.pageRecords, function(i, user){

		var trEle = document.createElement("tr");
		trEle.setAttribute("id", "userID_" + user.customerId);
		trEle.style.background=((i % 2 == 0)?"lightgray":"");
		
		var tdUserNo = document.createElement("td");
		var tdUserID = document.createElement("td");
		var tdUserPhone = document.createElement("td");
		var tdUserName = document.createElement("td");
		var tdUserAddress  = document.createElement("td");
		var tdAction  = document.createElement("td");
		
		tdUserNo.className="cell";
		tdUserID.className="cell";
		tdUserPhone.className="cell";
		tdUserName.className="cell";
		tdUserAddress.className="cell";
		tdAction.className="cell";
		
		var btEle = document.createElement("BUTTON");
		btEle.appendChild(document.createTextNode("View"));
		btEle.setAttribute("onclick", "loadShoppingCart('"+user.customerId+"')");
		btEle.setAttribute("type","button");
		btEle.className="addNew btn btn-success btn-sm" 
		
		tdUserNo.appendChild(document.createTextNode(( i + count)));
		tdUserID.appendChild(document.createTextNode(user.customerId));
		tdUserPhone.appendChild(document.createTextNode(user.phone));
		tdUserName.appendChild(document.createTextNode(user.userName));
		tdUserAddress.appendChild(document.createTextNode(user.address));
		tdAction.appendChild(btEle);
		
		trEle.appendChild(tdUserNo);
		trEle.appendChild(tdUserID);
		trEle.appendChild(tdUserPhone);
		trEle.appendChild(tdUserName);
		trEle.appendChild(tdUserAddress);
		trEle.appendChild(tdAction);
		
		$('#userTable > tbody:last-child').append(trEle);
	});
}