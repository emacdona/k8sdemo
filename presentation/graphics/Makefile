all: 00-nodes.eps 01-systemPods.eps 02-statelessAppPods.eps 03-statefulAppPods.eps 04-deployment.eps 05-statefulSet.eps 06-persistence.eps 07-persistentIdentity.eps 08-loadBalancer.eps 

00-nodes.eps: diagram.dia docker
	docker run --rm -i -v ${CURDIR}:/workdir k8spreso/dia --show-layers=Nodes --filter=eps-pango --export=00-nodes.eps diagram.dia
	
01-systemPods.eps: diagram.dia docker
	docker run --rm -i -v ${CURDIR}:/workdir k8spreso/dia --show-layers=Nodes,System --filter=eps-pango --export=01-systemPods.eps diagram.dia

02-statelessAppPods.eps: diagram.dia docker
	docker run --rm -i -v ${CURDIR}:/workdir k8spreso/dia --show-layers=Nodes,System,Stateless --filter=eps-pango --export=02-statelessAppPods.eps diagram.dia

03-statefulAppPods.eps: diagram.dia docker
	docker run --rm -i -v ${CURDIR}:/workdir k8spreso/dia --show-layers=Nodes,System,Stateless,Stateful --filter=eps-pango --export=03-statefulAppPods.eps diagram.dia

04-deployment.eps: diagram.dia docker
	docker run --rm -i -v ${CURDIR}:/workdir k8spreso/dia --show-layers=Nodes,System,Stateless,Stateful,Deployment --filter=eps-pango --export=04-deployment.eps diagram.dia

05-statefulSet.eps: diagram.dia docker
	docker run --rm -i -v ${CURDIR}:/workdir k8spreso/dia --show-layers=Nodes,System,Stateless,Stateful,Deployment,StatefulSet --filter=eps-pango --export=05-statefulSet.eps diagram.dia

06-persistence.eps: diagram.dia docker
	docker run --rm -i -v ${CURDIR}:/workdir k8spreso/dia --show-layers=Nodes,System,Stateless,Deployment,Stateful,StatefulSet,PersistentStorage --filter=eps-pango --export=06-persistence.eps diagram.dia

07-persistentIdentity.eps: diagram.dia docker
	docker run --rm -i -v ${CURDIR}:/workdir k8spreso/dia --show-layers=Nodes,System,Stateless,Deployment,Stateful,StatefulSet,PersistentStorage,HeadlessService --filter=eps-pango --export=07-persistentIdentity.eps diagram.dia

08-loadBalancer.eps: diagram.dia docker
	docker run --rm -i -v ${CURDIR}:/workdir k8spreso/dia --show-layers=Nodes,System,Stateless,Deployment,Stateful,StatefulSet,PersistentStorage,HeadlessService,LoadBalancers --filter=eps-pango --export=08-loadBalancer.eps diagram.dia

docker:
	docker build -t k8spreso/dia .

clean:
	rm -f *.eps *.pdf
