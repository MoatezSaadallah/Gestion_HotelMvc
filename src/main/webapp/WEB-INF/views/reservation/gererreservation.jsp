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
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Tableau de bord</h1>
					</div>
					<!-- /.col-lg-12 -->
				</div>

				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Informations général</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div id="dataTables-example_wrapper"
								class="dataTables_wrapper form-inline dt-bootstrap no-footer">
								<div class="row">
									<div class="col-sm-12">
										<table width="100%"
											class="table table-striped table-bordered table-hover dataTable no-footer dtr-inline collapsed"
											id="dataTables-example" role="grid"
											aria-describedby="dataTables-example_info"
											style="width: 100%;">
											<thead>
												<tr role="row">
													<th class="sorting_asc" tabindex="0"
														aria-controls="dataTables-example" rowspan="1" colspan="1"
														aria-sort="ascending"
														aria-label="Rendering engine: activate to sort column descending"
														style="width: 71px;">Date d'arrivé</th>

													<th class="sorting" tabindex="0"
														aria-controls="dataTables-example" rowspan="1" colspan="1"
														aria-label="Engine version: activate to sort column ascending"
														style="width: 71px;">Date de départ</th>
													<th class="sorting" tabindex="0"
														aria-controls="dataTables-example" rowspan="1" colspan="1"
														aria-label="Platform(s): activate to sort column ascending"
														style="width: 61px;">Nom</th>
													<th class="sorting" tabindex="0"
														aria-controls="dataTables-example" rowspan="1" colspan="1"
														aria-label="Browser: activate to sort column ascending"
														style="width: 61px;">Prénom</th>
													<th class="sorting" tabindex="0"
														aria-controls="dataTables-example" rowspan="1" colspan="1"
														aria-label="Engine version: activate to sort column ascending"
														style="width: 61px;">Numéro de piéce</th>
													<th class="sorting" tabindex="0"
														aria-controls="dataTables-example" rowspan="1" colspan="1"
														aria-label="Engine version: activate to sort column ascending"
														style="width: 30px;">Action</th>

												</tr>
											</thead>
											<tbody>
												<c:forEach items="${clients }" var="client">


													<tr class="gradeA odd" role="row">
														<td class="sorting_1">${client.reservation.getDate_Arrive() }</td>
														<td>${client.reservation.getDate_Depart() }</td>
														<td>${client.getNom() }</td>
														<td>${client.getPrenom() }</td>
														<td class="center">${client.getNum_Piece() }</td>
														<td class="center"><c:url
																value="/reservation/gererreservation/modifier/${client.getId_Client() }"
																var="urlModif" /> <a href="${urlModif }"><button
																	type="button" class="btn btn-primary btn-circle">
																	<i class="fa fa-list"></i>
																</button> </a> <c:url
																value="/reservation/gererreservation/supprimer/${client.getId_Client()}"
																var="urlSuppression" /> <a href="${urlSuppression }">
																<button type="button" class="btn btn-warning btn-circle">
																	<i class="fa fa-times"></i>
																</button>
														</a></td>


													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
								<!-- /.table-responsive -->
							</div>
							<!-- /.panel-body -->
						</div>
					</div>
				</div>
			</div>
			<!-- /.panel -->
			<div class="panel panel-default">
				<div class="panel-heading">Modifier une réservation</div>
				<c:url
					value="/reservation/gererreservation/enregistrer/${client.getId_Client()}"
					var="urlEnregistrer" />
				<f:form modelAttribute="client" action="${urlEnregistrer }"
					method="get">

					<div class="panel-body">
						<div class="col-md-6">
							<div class="col-lg-12">
								<div class="panel panel-default">
									<div class="panel-body">

										<div class="form-group">
											<label>Nom </label> <input type="text" name="nom" id="nom"
												class="form-control" placeholder=""
												value="${client.getNom() }" />
										</div>
										<div class="form-group">
											<label>Prénom</label> <input type="text" name="prenom"
												id="prenom" class="form-control" placeholder=""
												value="${client.getPrenom() }" />
										</div>

										<div class="form-group">
											<label>Nationalité</label> <input type="text"
												name="nationalite" id="nationalite" class="form-control"
												placeholder="" value="${client.getNationalite() }" />
										</div>
										<div class="form-group">
											<label>Type de piéce</label> <input type="text"
												name="type_Piece" id="type_Piece" class="form-control"
												placeholder="" value="${client.getType_Piece() }" />
										</div>
										<div class="form-group">
											<label>Numéro de piéce</label> <input type="text"
												name="num_Piece" id="num_Piece" class="form-control"
												placeholder="" value="${client.getNum_Piece() }" />
										</div>
										<div class="form-group">
											<label>Téléphone</label> <input type="text" name="telephone"
												id="telephone" class="form-control" placeholder=""
												value="${client.getTelephone() }" />
										</div>
										<div class="form-group">
											<label>Adresse de résidence</label> <input type="text"
												name="adresse" id="adresse" class="form-control"
												placeholder="" value="${client.getAdresse() }" />
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="col-md-6">
							<div class="col-lg-12">
								<div class="panel panel-default">
									<div class="panel-body">



										<div class="form-group">
											<label>Date d'arrivé</label>
											<div class='input-group date' id='datetimepicker6'>
												<input type='date' name="date_Arrive" class="form-control"
													value="${client.reservation.getDate_Arrive() }" /> <span
													class="input-group-addon"> <span
													class="glyphicon glyphicon-calendar"></span>
												</span>
											</div>
										</div>

										<div class="form-group">
											<label>Date de Départ</label>
											<div class='input-group date' id='datetimepicker7'>
												<input type='date' name="date_Depart" class="form-control"
													value="${client.reservation.getDate_Depart() }" /> <span
													class="input-group-addon"> <span
													class="glyphicon glyphicon-calendar"></span>
												</span>
											</div>
										</div>

										<div class="form-group">
											<label>Nombre de personne</label> <input type="text"
												name="nbre_Personnes" id="nbre_Personnes"
												class="form-control" placeholder=""
												value="${client.reservation.getNbre_Personnes() }" />
										</div>

										<div class="form-group">
											<label>Numéro de la chambre</label> <input type="text"
												name="num_Chambre" id="num_Chambre" class="form-control"
												placeholder=""
												value="${client.reservation.chambre.getId_Chambre() }" />
										</div>
										<div class="form-group">
											<div class="checkbox">
												<label> <input
													type="checkbox" value="">Petit déjeuner
												</label>
											</div>
											<div class="checkbox">
												<label> <input type="checkbox" value="">Lit
													supplémentaire
												</label>
											</div>
											<div class="checkbox">
												<label> <input type="checkbox" value="">Lit
													bebe
												</label>
											</div>
										</div>
										<div class="form-group">
											<label>Commentaire</label>
											<textarea class="form-control" name="commentaire" rows="3"> <c:out
													value="${client.reservation.getCommentaire() }" /></textarea>
										</div>

									</div>

								</div>
								<button type="submit" class="btn btn-primary">
									<i class="fa fa-save">&nbsp;Valider</i>
								</button>
								<a href="<c:url value="/reservation/ajouterchambre" />"
									class="btn btn-danger"> <i class="fa fa-arrow-left">&nbsp;Reset</i>
								</a>
							</div>
						</div>
					</div>
				</f:form>

			</div>

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
