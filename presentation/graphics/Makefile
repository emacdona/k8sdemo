all: manifest-types.eps 00-nodes.eps 01-systemPods.eps 02-statelessAppPods.eps 03-statefulAppPods.eps 04-deployment.eps 05-statefulSet.eps 06-persistence.eps 07-persistentIdentity.eps 08-loadBalancer.eps deploy-00-app.eps deploy-01-appContainerized.eps deploy-02-containerToRepo.eps deploy-03-emptyPods.eps deploy-04-podsWithContainers.eps simplifiedModel-00.eps

manifest-types.eps: ManifestTypes.dia docker-built
	docker run --rm -i -v ${CURDIR}:/workdir k8spreso/dia --filter=eps-pango --export=manifest-types.eps ManifestTypes.dia

00-nodes.eps: diagram.dia docker-built
	docker run --rm -i -v ${CURDIR}:/workdir k8spreso/dia --show-layers=Nodes --filter=eps-pango --export=00-nodes.eps diagram.dia
	
01-systemPods.eps: diagram.dia docker-built
	docker run --rm -i -v ${CURDIR}:/workdir k8spreso/dia --show-layers=Nodes,System --filter=eps-pango --export=01-systemPods.eps diagram.dia

02-statelessAppPods.eps: diagram.dia docker-built
	docker run --rm -i -v ${CURDIR}:/workdir k8spreso/dia --show-layers=Nodes,Stateless --filter=eps-pango --export=02-statelessAppPods.eps diagram.dia

03-statefulAppPods.eps: diagram.dia docker-built
	docker run --rm -i -v ${CURDIR}:/workdir k8spreso/dia --show-layers=Nodes,System,Stateless,Stateful --filter=eps-pango --export=03-statefulAppPods.eps diagram.dia

04-deployment.eps: diagram.dia docker-built
	docker run --rm -i -v ${CURDIR}:/workdir k8spreso/dia --show-layers=Nodes,System,Stateless,Deployment --filter=eps-pango --export=04-deployment.eps diagram.dia

05-statefulSet.eps: diagram.dia docker-built
	docker run --rm -i -v ${CURDIR}:/workdir k8spreso/dia --show-layers=Nodes,System,Stateless,Stateful,Deployment,StatefulSet --filter=eps-pango --export=05-statefulSet.eps diagram.dia

06-persistence.eps: diagram.dia docker-built
	docker run --rm -i -v ${CURDIR}:/workdir k8spreso/dia --show-layers=Nodes,System,Stateless,Deployment,Stateful,StatefulSet,PersistentStorage --filter=eps-pango --export=06-persistence.eps diagram.dia

07-persistentIdentity.eps: diagram.dia docker-built
	docker run --rm -i -v ${CURDIR}:/workdir k8spreso/dia --show-layers=Nodes,System,Stateless,Deployment,Stateful,StatefulSet,PersistentStorage,HeadlessService --filter=eps-pango --export=07-persistentIdentity.eps diagram.dia

08-loadBalancer.eps: diagram.dia docker-built
	docker run --rm -i -v ${CURDIR}:/workdir k8spreso/dia --show-layers=Nodes,Stateless,Deployment,LoadBalancers --filter=eps-pango --export=08-loadBalancer.eps diagram.dia

simplifiedModel-00.eps: simplifiedModel.dia docker-built
	docker run --rm -i -v ${CURDIR}:/workdir k8spreso/dia --show-layers=Nodes,Stateless,Deployment,LoadBalancers --filter=eps-pango --export=simplifiedModel-00.eps simplifiedModel.dia

deploy-00-app.eps: deployToKube.dia docker-built
	docker run --rm -i -v ${CURDIR}:/workdir k8spreso/dia --show-layers=Boundary,App --filter=eps-pango --export=deploy-00-app.eps deployToKube.dia

deploy-01-appContainerized.eps: deployToKube.dia docker-built
	docker run --rm -i -v ${CURDIR}:/workdir k8spreso/dia --show-layers=Boundary,Docker --filter=eps-pango --export=deploy-01-appContainerized.eps deployToKube.dia

deploy-02-containerToRepo.eps: deployToKube.dia docker-built
	docker run --rm -i -v ${CURDIR}:/workdir k8spreso/dia --show-layers=Boundary,ImageRepo --filter=eps-pango --export=deploy-02-containerToRepo.eps deployToKube.dia

deploy-03-emptyPods.eps: deployToKube.dia docker-built
	docker run --rm -i -v ${CURDIR}:/workdir k8spreso/dia --show-layers=Boundary,ImageRepo,PodsWithoutContainers --filter=eps-pango --export=deploy-03-emptyPods.eps deployToKube.dia

deploy-04-podsWithContainers.eps: deployToKube.dia docker-built
	docker run --rm -i -v ${CURDIR}:/workdir k8spreso/dia --show-layers=Boundary,ImageRepo,PodsWithoutContainers,PodsWithContainers --filter=eps-pango --export=deploy-04-podsWithContainers.eps deployToKube.dia


docker-built: Dockerfile
	docker build -t k8spreso/dia .
	touch docker-built

clean:
	rm -f *.eps *.pdf .*.un~ docker-built
