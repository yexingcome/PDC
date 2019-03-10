package io.renren.modules.dds.entity.v1.request.deleteAuthorization;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "SOAP-ENV:Body")
public class RequestBody {
	@XmlElement(required = true, name = "ns1:deleteAuthorization")
	private DeleteAuthorization deleteAuthorization;

	public DeleteAuthorization getDeleteAuthorization() {
		return deleteAuthorization;
	}

	public void setDeleteAuthorization(DeleteAuthorization deleteAuthorization) {
		this.deleteAuthorization = deleteAuthorization;
	}

}
