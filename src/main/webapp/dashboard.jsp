<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8" />
<link rel="icon" type="image/png" href="assets/img/favicon.ico">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>Light Bootstrap Dashboard by Creative Tim</title>

<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />


<!-- Bootstrap core CSS     -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />

<!-- Animation library for notifications   -->
<link href="assets/css/animate.min.css" rel="stylesheet" />

<!--  Light Bootstrap Table core CSS    -->
<link href="assets/css/light-bootstrap-dashboard.css?v=1.4.0"
	rel="stylesheet" />


<!--  CSS for Demo Purpose, don't include it in your project     -->
<link href="assets/css/demo.css" rel="stylesheet" />


<!--     Fonts and icons     -->
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300'
	rel='stylesheet' type='text/css'>
<link href="assets/css/pe-icon-7-stroke.css" rel="stylesheet" />

</head>
<body>

	<div class="wrapper">

		<!-- SIDEBAR -->
		<jsp:include page="WEB-INF/template/sidebar.jsp" />

		<div class="main-panel">

			<!-- HEADER -->
			<jsp:include page="WEB-INF/template/header.jsp" />

			<!-- CONTENT -->
			<div class="content">
				<div class="container-fluid">
					<div class="col-md-8">
						<div class="card">
							<div class="header">
								<h4 class="title">Data Barang</h4>
							</div>
							<div class="content">
								<form method="post" action="/dashboard/save" id="form-barang">
									<div class="row">
										<div class="col-md-4">
											<div class="form-group">
												<label>Kode Barang</label> <input name = "kodeBarang" type="text"
													class="form-control" placeholder="Kode Barang">
											</div>
										</div>
										<div class="col-md-8">
											<div class="form-group">
												<label>Nama Barang</label> <input name = "namaBarang" type="text"
													class="form-control" placeholder="Nama Barang">
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-5">
											<div class="form-group">
												<label>Harga Beli</label> <input name = "hargaBeli"  type="number"
													class="form-control" placeholder="Harga Beli">
											</div>
										</div>
										<div class="col-md-5">
											<div class="form-group">
												<label>Harga Jual</label> <input name = "hargaJual" type="number"
													class="form-control" placeholder="Harga Jual">
											</div>
										</div>
										<div class="col-md-2">
											<div class="form-group">
												<label>Stok</label> <input name = "stok" type="number"
													class="form-control" placeholder="Stok">
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12">
											<div class="form-group">
												<label>Spesifikasi</label>
												<textarea name = "spesifikasi" rows="5" class="form-control"
													placeholder="Here can be your description"></textarea>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12">
											<div class="form-group">
												<label>Keterangan</label>
												<textarea name = "keterangan" rows="5" class="form-control"
													placeholder="Here can be your description"></textarea>
											</div>
										</div>
									</div>

									<button type="submit" class="btn btn-info btn-fill pull-right">
										<i class="pe-7s-news-paper"></i> Simpan
									</button>
									<div class="clearfix"></div>
								</form>
							</div>
						</div>
					</div>

				</div>
			</div>

			<!-- FOOTER -->
			<jsp:include page="WEB-INF/template/footer.jsp" />

		</div>
	</div>


</body>

<!--   Core JS Files   -->
<script src="assets/js/jquery.3.2.1.min.js" type="text/javascript"></script>
<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

<!--  Charts Plugin -->
<script src="assets/js/chartist.min.js"></script>

<!--  Notifications Plugin    -->
<script src="assets/js/bootstrap-notify.js"></script>

<!--  Google Maps Plugin    -->
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>

<!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
<script src="assets/js/light-bootstrap-dashboard.js?v=1.4.0"></script>

<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
<script src="assets/js/demo.js"></script>

<!-- function growl -->
<script type="text/javascript">
	/* 	$(document)
	 .ready(
	 function() {

	 demo.initChartist();

	 $
	 .notify(
	 {
	 icon : 'pe-7s-gift',
	 message : "Welcome to <b>Light Bootstrap Dashboard</b> - a beautiful freebie for every web developer."

	 }, {
	 type : 'info',
	 timer : 4000
	 });

	 }); */
</script>

</html>