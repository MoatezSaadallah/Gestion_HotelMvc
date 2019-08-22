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
			<div class="container-fluid">
				<div class="row">
					<br>

					<div class="panel panel-default">
						<div class="panel-heading">Ajout d'une chambre</div>
						<c:url value="/administration/ajouterchambre/enregistrer"
							var="urlEnregistrer" />
						<f:form modelAttribute="chambre" action="${urlEnregistrer }"
							method="get">

							<div class="panel-body">
								<div class="col-md-6">

									<div class="col-lg-12">
										<div class="panel panel-default">
											<div class="panel-body">
												<div class="form-group">
													<label>Numéro de la chambre</label> <input type="text"
														name="id_Chambre" class="form-control" placeholder=""
														value="${chambre.getId_Chambre() }" />
												</div>

												<div class="form-group">
													<label>Nombre de place</label> <input type="text"
														name="nbr_Place" class="form-control" placeholder=""
														value="${chambre.getNbr_Place() }" />
												</div>
												<div class="form-group">
													<label>Type</label> <input type="text" name="type"
														class="form-control" placeholder=""
														value="${chambre.getType() }" />
												</div>
												<div class="form-group">
													<label>Etat</label> <input type="text" name="etat"
														class="form-control" placeholder=""
														value="${chambre.getEtat() }" />
												</div>
												<label>Tarif</label>
												<div class="form-group input-group">
													<span class="input-group-addon"><i class="fa fa-eur"></i>
													</span> <input type="text" name="tarif" class="form-control"
														placeholder="" value="${chambre.getTarif() }">
												</div>



											</div>
												<button type="submit" class="btn btn-primary">
													<i class="fa fa-save">Valider</i>
												</button>
											<a href="<c:url value="/reservation/ajouterchambre" />"
												class="btn btn-danger"> <i class="fa fa-arrow-left">Reset</i>
											</a>
										</div>
									</div>
								</div>
						</f:form>

						<div class="col-md-6">


							<div class="panel-body">
								<table width="100%"
									class="table table-striped table-bordered table-hover"
									id="dataTables-example">
									<thead>
										<tr>
											<th>N°</th>
											<th>Nbre Place</th>
											<th>Etat</th>
											<th>Type</th>
											<th>Tarif</th>

										</tr>
									</thead>
									<tbody>
										<c:forEach items="${chambres }" var="chambre">
											<tr class="odd gradeX">
												<td>${chambre.getId_Chambre() }</td>
												<td>${chambre.getNbr_Place() }</td>
												<td>${chambre.getEtat() }</td>
												<td>${chambre.getType() }</td>
												<td>${chambre.getTarif() }</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<!-- /.table-responsive -->
							</div>


						</div>
					</div>

				</div>
			</div>
		</div>
	</div>



	<!-- /#page-wrapper -->

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
</body>

</html>
