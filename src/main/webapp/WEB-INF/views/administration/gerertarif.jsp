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

<!-- DataTables CSS -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/datatables-plugins/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/datatables-responsive/dataTables.responsive.css"
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
						<div class="panel-heading">Gérer Tarif</div>
						<c:url
							value="/administration/gerertarif/enregistrer/${tarif.getId_Tarif() }"
							var="urlEnregistrer" />
						<f:form modelAttribute="tarif" action="${urlEnregistrer }"
							method="get">

							<div class="panel-body">
								<div class="col-md-6">

									<div class="col-lg-12">
										<div class="panel panel-default">
											<div class="panel-body">


												<label>Taxe de Sejour</label>
												<div class="form-group input-group">
													<span class="input-group-addon"><i class="fa fa-eur"></i>
													</span> <input type="text" name="taxesejour" class="form-control"
														placeholder="" value="${tarif.getTaxeSejour() }">
												</div>

												<label>Petit Déjeuner</label>
												<div class="form-group input-group">
													<span class="input-group-addon"><i class="fa fa-eur"></i>
													</span> <input type="text" name="petitdej" class="form-control"
														placeholder="" value="${tarif.getPetitDej() }">
												</div>

												<label>Lit supplémentaire</label>
												<div class="form-group input-group">
													<span class="input-group-addon"><i class="fa fa-eur"></i>
													</span> <input type="text" name="litsupp" class="form-control"
														placeholder="" value="${tarif.getLitSupp() }">
												</div>

												<label>Lit bébé</label>
												<div class="form-group input-group">
													<span class="input-group-addon"><i class="fa fa-eur"></i>
													</span> <input type="text" name="litbebe" class="form-control"
														placeholder="" value="${tarif.getLitBebe() }">
												</div>

											</div>

										</div>
										<button type="submit" class="btn btn-primary">
											<i class="fa fa-save">Valider</i>
										</button>
										<a href="<c:url value="/administration/ajoutertarif" />"
											class="btn btn-danger"> <i class="fa fa-arrow-left">Reset</i>
										</a>
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
											<th width="25%">Taxe de Séjour</th>
											<th width="25%">Petit Déjeuner</th>
											<th width="25%">Lit supplémentaire</th>
											<th width="25%">Lit bébé</th>
											<th>Action</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${tarifs }" var="tarif">
											<tr class="odd gradeX">
												<td>${tarif.getTaxeSejour() }</td>
												<td>${tarif.getPetitDej() }</td>
												<td>${tarif.getLitSupp() }</td>
												<td>${tarif.getLitBebe() }</td>
												<td><c:url
														value="/administration/gerertarif/modifier/${tarif.getId_Tarif()}"
														var="urlModif" /> <a href="${urlModif }"><button
															type="button" class="btn btn-outline btn-primary">Modifier</button></a>
												</td>
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
	<!-- DataTables JavaScript -->
	<script
		src="<%=request.getContextPath()%>/resources/vendor/datatables/js/jquery.dataTables.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/vendor/datatables-responsive/dataTables.responsive.js"></script>

</body>

</html>
