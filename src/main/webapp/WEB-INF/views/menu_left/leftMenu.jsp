<div class="navbar-default sidebar" role="navigation">
	<div class="sidebar-nav navbar-collapse">
		<ul class="nav in" id="side-menu">
			<li class="sidebar-search">
				<center>
					<img src="<c:url value="/resources/images/logo.png" />"
						width="100" height="100" />
				</center>
				<div class="input-group custom-search-form"></div> <!-- /input-group -->
			</li>
			<c:url value="/home/" var="home" />
			<li><a href="${home }"><i class="fa fa-dashboard fa-fw"></i>
					Tableau de bord</a></li>
			<c:url value="/client/info" var="clientinfo" />
			<li><a href="${clientinfo }"><i class="fa fa-table fa-fw"></i>
					Informations clients</a></li>
			<c:url value="/reservation/" var="reservation" />
			<li><a href="${reservation }"><i
					class="fa fa-bar-chart-o fa-fw"></i> Gestion des réservations <span
					class="fa arrow"></span></a>
				<ul class="nav nav-second-level collapse">
					<c:url value="/reservation/reserverchambre" var="reserverchambre" />
					<li><a href="${reserverchambre }">Réserver une chambre</a></li>
					<c:url value="/reservation/gererreservation" var="gererreservation" />
					<li><a href="${gererreservation }">Gérer une réservation</a></li>
				</ul> <!-- /.nav-second-level --></li>





			<c:url value="/administration/" var="administration" />
			<li><a href="${administration }"><i
					class="fa fa-wrench fa-fw"></i> Administration <span
					class="fa arrow"></span></a>
				<ul class="nav nav-second-level collapse">
					<c:url value="/administration/ajouterchambre"
						var="adminajouterchambre" />
					<li><a href="${adminajouterchambre }">Ajouter une chambre</a></li>
					<c:url value="/administration/gererchambre" var="admingererchambre" />
					<li><a href="${admingererchambre }">Gérer une chambre</a></li>
					<c:url value="/administration/gerertarif" var="admingerertarif" />
					<li><a href="${admingerertarif }">Gérer les tarifs</a></li>
				</ul> <!-- /.nav-second-level --></li>



		</ul>
		<!-- /.nav-second-level -->
	</div>
	<!-- /.sidebar-collapse -->
</div>