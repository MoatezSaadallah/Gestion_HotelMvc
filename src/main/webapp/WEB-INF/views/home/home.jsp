<%@ include file="/WEB-INF/views/includes/includes.jsp"%>
<!DOCTYPE html>
<html lang="fr">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Gestion d'hotel</title>

<!-- Bootstrap Core CSS -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- DataTables CSS -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/datatables-plugins/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/datatables-responsive/dataTables.responsive.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link
	href="<%=request.getContextPath()%>/resources/dist/css/sb-admin-2.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">

			<%@ include file="/WEB-INF/views/menu_top/topMenu.jsp"%>

			<%@ include file="/WEB-INF/views/menu_left/leftMenu.jsp"%>
			<!-- /.navbar-static-side -->
		</nav>

		<!-- Page Content -->
		<div id="page-wrapper">

			<br>
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">Disponibilit� des chambres</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>Num�ro</th>
										<th>Etat</th>
										<th>Date Arriv�</th>
										<th>Date D�part</th>
										<th>Nom</th>
										<th>Pr�nom</th>
										<th>Check</th>



									</tr>
								</thead>
								<tbody>
									<c:forEach items="${chambres }" var="chambre">
										<tr>
											<td>Chambre ${chambre.getId_Chambre() }</td>
											<td>${chambre.getEtat()}</td>
											<td>${chambre.reservation.getDate_Arrive() }</td>
											<td>${chambre.reservation.getDate_Depart() }</td>
											<td>${chambre.reservation.client.getNom() }</td>
											<td>${chambre.reservation.client.getPrenom() }</td>
											<td>
											<c:set var="etatreserve" scope="session" value="Reserv�" />
											<c:url
													value="/home/checkin/${chambre.reservation.client.getId_Client() }"
													var="urlcheck" /> <a href="${urlcheck }">
													<button type="button" class="btn btn-success btn-circle">
														IN
													</button>
											</a>
											      <c:set var = "etatoccupe" scope = "session" value = "Occup�"/>
											<c:url
													value="/home/checkout/${chambre.reservation.client.getId_Client() }"
													var="urlcheck" /> <a href="${urlcheck }">
												<button type="button" class="btn btn-danger btn-circle">
													OUT
												</button></a>
												</td>


										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<!-- /.table-responsive -->
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
			</div>




		</div>
		<!-- /#wrapper -->

		<!-- jQuery -->
		<script
			src="<%=request.getContextPath()%>/resources/vendor/jquery/jquery.min.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script
			src="<%=request.getContextPath()%>/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

		<!-- Metis Menu Plugin JavaScript -->
		<script
			src="<%=request.getContextPath()%>/resources/vendor/metisMenu/metisMenu.min.js"></script>

		<!-- Custom Theme JavaScript -->
		<script
			src="<%=request.getContextPath()%>/resources/dist/js/sb-admin-2.js"></script>
		<!-- DataTables JavaScript -->
		<script
			src="<%=request.getContextPath()%>/resources/vendor/datatables/js/jquery.dataTables.min.js"></script>
		<script
			src="<%=request.getContextPath()%>/resources/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
		<script
			src="<%=request.getContextPath()%>/resources/vendor/datatables-responsive/dataTables.responsive.js"></script>


		<!-- Page-Level Demo Scripts - Tables - Use for reference -->
		<script>
			$(document).ready(function() {
				$('#dataTables-example').DataTable({
					responsive : true
				});
			});
		</script>
</body>

</html>
