
dhtmlXGridObject.prototype.xD = dhtmlXGridObject.prototype.attachHeader;
dhtmlXGridObject.prototype.attachHeader = function () {
	this.xD.apply(this, arguments);
	if (this.nh) {
		return true;
	}
	this.CC();
	if (typeof (this.sY) == "undefined") {
		this.submitOnlyChanged(true);
	}
	if (typeof (this.DO) == "undefined") {
		this.BP(true);
	}
	var that = this;
	this.xc = [];
	this.ho = [];
	this.attachEvent("onRowAdded", function (id) {
		that.xc.push(id);
		that.amz(id, function (a) {
			a.cell.hy = true;
		});
		return true;
	});
	this.attachEvent("onBeforeRowDeleted", function (id) {
		that.ho.push(id);
		return true;
	});
	this.attachHeader = this.xD;
};
dhtmlXGridObject.prototype.CC = function () {
	this.qs = this.we();
	if (this.qs === false) {
		return false;
	}
	if (this.zI) {
		return;
	}
	this.vn = new Array();
	var self = this;
	dhtmlxEvent(this.qs, "submit", function () {
		if (self.aL) {
			self.ym();
		}
	});
	this.zI = true;
};
dhtmlXGridObject.prototype.ym = function () {
	this.vr();
	if (!this.callEvent("onBeforeFormSubmit", [])) {
		return false;
	}
};
dhtmlXGridObject.prototype.submitOnlyChanged = function (mode) {
	this.sY = ap(mode);
};
dhtmlXGridObject.prototype.submitColumns = function (uY) {
	if (typeof uY == "string") {
		uY = uY.split(this.gX);
	}
	this._submit_cols = uY;
};
dhtmlXGridObject.prototype.setFieldName = function (mask) {
	mask = mask.replace(/\{GRID_ID\}/g, "'+a1+'");
	mask = mask.replace(/\{ROW_ID\}/g, "'+a2+'");
	mask = mask.replace(/\{ROW_INDEX\}/g, "'+this.getRowIndex(a2)+'");
	mask = mask.replace(/\{COLUMN_INDEX\}/g, "'+a3+'");
	mask = mask.replace(/\{COLUMN_ID\}/g, "'+this.getColumnId(a3)+'");
	this._input_mask = Function("a1", "a2", "a3", "return '" + mask + "';");
};
dhtmlXGridObject.prototype.submitSerialization = function (mode) {
	this.FormSubmitSerialization = ap(mode);
};
dhtmlXGridObject.prototype.BP = function (mode) {
	this.DO = ap(mode);
};
dhtmlXGridObject.prototype.submitOnlySelected = function (mode) {
	this.wN = ap(mode);
};
dhtmlXGridObject.prototype.submitOnlyRowID = function (mode) {
	this.yg = ap(mode);
};
dhtmlXGridObject.prototype.createFormInput = function (name, value) {
	var input = document.createElement("input");
	input.type = "hidden";
	if (this._input_mask) {
		input.name = this._input_mask.apply(this, name);
	} else {
		input.name = ((this.globalBox || this.aL).id || "dhtmlXGrid") + "_" + name;
	}
	input.value = value;
	this.qs.appendChild(input);
	this.vn.push(input);
};
dhtmlXGridObject.prototype.createFormInputRow = function (r) {
	var id = (this.globalBox || this.aL).id;
	for (var j = 0; j < this.gA; j++) {
		var Ft = this.cells3(r, j);
		if (((!this.sY) || Ft.hy()) && (!this._submit_cols || this._submit_cols[j])) {
			this.createFormInput(this._input_mask ? [id, r.idd, j] : (r.idd + "_" + j), Ft.getValue());
		}
	}
};
dhtmlXGridObject.prototype.vr = function () {
	if (this.qs == false) {
		return false;
	}
	for (var i = 0; i < this.vn.length; i++) {
		this.qs.removeChild(this.vn[i]);
	}
	this.vn = new Array();
	if (this.FormSubmitSerialization) {
		this.createFormInput("serialized", this.serialize());
	} else {
		if (this.wN) {
			if (this.yg) {
				this.createFormInput("selected", this.bI());
			} else {
				for (var i = 0; i < this.bY.length; i++) {
					this.createFormInputRow(this.bY[i]);
				}
			}
		} else {
			if (this.DO) {
				if (this.xc.length) {
					this.createFormInput("rowsadded", this.xc.join(","));
				}
				if (this.ho.length) {
					this.createFormInput("rowsdeleted", this.ho.join(","));
				}
			}
			this.forEachRow(function (id) {
				this.dz(id);
				this.createFormInputRow(this.bj[id]);
			});
		}
	}
};
dhtmlXGridObject.prototype.we = function () {
	var qs = false;
	var parent = this.aL;
	while (parent && parent.tagName && parent != document.body) {
		if (parent.tagName.toLowerCase() == "form") {
			qs = parent;
			break;
		} else {
			parent = parent.parentNode;
		}
	}
	return qs;
};

