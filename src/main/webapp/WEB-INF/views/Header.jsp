<div class="masthead">
	<h3 ng-if="authenticated" class="text-info">ICare</h3>
	<nav ng-if="authenticated">
		<ul class="nav nav-justified">
			<li><a href="#/home">Home</a></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" role="button" aria-haspopup="true"
				aria-expanded="false">Patients <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li ng-if="username=='compounder'"><a
						href="patient/addpatient">Create</a></li>
					<li><a href="/patient/search">Search</a></li>
				</ul></li>
			<li ng-if="username=='compounder'"><a
				href="#/appointment/create">Appointment</a></li>
			<li ng-if="username=='compounder'"><a href="#/appointment/queue">Queues</a></li>
			<li><a href="#/logout">Logout</a></li>
		</ul>
	</nav>
</div>