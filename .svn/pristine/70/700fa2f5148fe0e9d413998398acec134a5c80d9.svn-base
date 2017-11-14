
dhtmlXGridObject.prototype.cO = function (z) {
	if (!z.update || z.id == 0) {
		return;
	}
	if (this.bj[z.id].JW) {
		this.bj[z.id].JW.src = this.eg + z.state + ".gif";
	}
};
dhtmlXGridObject.prototype.doExpand = function (obj) {
	this.editStop();
	var row = obj.parentNode.parentNode.parentNode;
	var r = this._h2.get[row.idd];
	if (!this.callEvent("onOpen", [row.idd, (r.state == "plus" ? -1 : 1)])) {
		return;
	}
	if (r.state == "plus") {
		this.expandKids(row);
	} else {
		if ((r.state == "minus") && (!r.aaZ)) {
			this.collapseKids(row);
		}
	}
};
function dhtmlxHierarchy() {
	var z = {id:0, bu:[], gR:-1, parent:null, index:0, state:dhtmlXGridObject.uT};
	this.order = [z];
	this.get = {"0":z};
	this.aqd = function (a, b) {
		var p = a.parent;
		var z = a.index;
		p.bu[z] = b;
		p.bu[b.index] = a;
		a.index = b.index;
		b.index = z;
	};
	this.forEachChildF = function (id, xj, that, funct2) {
		var z = this.get[id];
		for (var i = 0; i < z.bu.length; i++) {
			if (!xj.apply((that || this), [z.bu[i]])) {
				continue;
			}
			if (z.bu[i].bu.length) {
				this.forEachChildF(z.bu[i].id, xj, that, funct2);
			}
			if (funct2) {
				funct2.call((that || this), z.bu[i]);
			}
		}
	};
	this.so = function (id, xj, that) {
		var z = this.get[id];
		for (var i = 0; i < z.bu.length; i++) {
			xj.apply((that || this), [z.bu[i]]);
			if (z.bu[i].bu.length) {
				this.so(z.bu[i].id, xj, that);
			}
		}
	};
	this.JA = function (id, name, val) {
		var z = this.get[id];
		if (z[name] == val) {
			return;
		}
		z[name] = val;
		z.update = true;
	};
	this.add = function (id, parentId) {
		return this.Oj(id, parentId);
	};
	this.Oj = function (id, parentId, RH, arK) {
		var z = this.get[parentId || 0];
		if (RH) {
			var ind = this.get[RH].index + (arK ? 0 : 1);
		} else {
			var ind = z.bu.length;
		}
		var x = {id:id, bu:[], gR:z.gR + 1, parent:z, index:ind, state:dhtmlXGridObject.uT};
		if (z.state == dhtmlXGridObject.uT) {
			this.JA(parentId, "state", (parentId == 0 ? "minus" : "plus"));
		}
		if (RH) {
			for (var i = ind; i < z.bu.length; i++) {
				z.bu[i].index++;
			}
			z.bu = z.bu.slice(0, ind).concat([x]).concat(z.bu.slice(ind, z.bu.length));
		} else {
			z.bu.push(x);
		}
		this.get[id] = x;
		return x;
	};
	this.acA = function (id, parentId, afp) {
		return this.Oj(id, parentId, afp, true);
	};
	this.remove = function (id) {
		var z = this.get[id || 0];
		for (var i = 0; i < z.bu.length; i++) {
			this.SS(z.bu[i].id);
		}
		z.bu = [];
		z.parent.bu = z.parent.bu.slice(0, z.index).concat(z.parent.bu.slice(z.index + 1));
		for (var i = z.index; i < z.parent.bu.length; i++) {
			z.parent.bu[i].index--;
		}
		delete this.get[id];
	};
	this.SS = function (id) {
		var z = this.get[id || 0];
		for (var i = 0; i < z.bu.length; i++) {
			this.SS(z.bu[i].id);
		}
		z.bu = [];
		delete this.get[id];
	};
	return this;
}
dhtmlXGridObject.prototype.jS = function (id, start) {
	var z = this._h2.get[id].bu;
	start += z.length;
	for (var i = 0; i < z.length; i++) {
		if (z[i].bu.length && z[i].state == "minus") {
			start += this.jS(z[i].id, 0);
		}
	}
	return start;
};
dhtmlXGridObject.prototype.collapseKids = function (uG) {
	var r = this._h2.get[uG.idd];
	if (r.state != "minus") {
		return;
	}
	if (!this.callEvent("onOpenStart", [uG.idd, 1])) {
		return;
	}
	var start = uG.rowIndex;
	if (start < 0) {
		start = this.am.bP(uG) + 1;
	}
	this._h2.JA(r.id, "state", "plus");
	this.cO(r);
	if (this.ahK || this.aW) {
		this._h2_to_buff();
		this.uR();
	} else {
		var len = this.jS(this.am[start - 1].idd, 0);
		for (var i = 0; i < len; i++) {
			this.am[start + i].parentNode.removeChild(this.am[start + i]);
		}
		this.am.splice(start, len);
	}
	this.callEvent("onGridReconstructed", []);
	this.setSizes();
	this._h2_to_buff();
	this.callEvent("onOpenEnd", [uG.idd, -1]);
};
dhtmlXGridObject.prototype.MI = function (r, start, ind, Ch) {
	var alD = [];
	var asv = (cn ? this.obj : this.obj.rows[0].parentNode);
	this._h2_to_buff();
	if (this.ahK || this.aW) {
		return this.uR();
	}
	var len = this.jS(r.id, 0);
	for (var i = 0; i < len; i++) {
		var ra = this.render_row(ind + i);
		if (start) {
			start.parentNode.insertBefore(ra, start);
		} else {
			asv.appendChild(ra);
		}
		alD.push(ra);
	}
	this.am = dhtmlxArray(this.am.slice(0, ind).concat(alD).concat(this.am.slice(ind)));
	return r.bu.length + alD.length;
};
dhtmlXGridObject.prototype.expandKids = function (uG, sEv) {
	var r = this._h2.get[uG.idd];
	if ((!r.bu.length) && (!r.TP)) {
		return;
	}
	if (r.state != "plus") {
		return;
	}
	if (!r.Oo && !sEv) {
		if (!this.callEvent("onOpenStart", [r.id, -1])) {
			return;
		}
	}
	var start = this.getRowIndex(r.id) + 1;
	if (r.bu.length) {
		r.Oo = false;
		this._h2.JA(r.id, "state", "minus");
		this.cO(r);
		var len = this.MI(r, this.am[start], start);
		this.callEvent("onGridReconstructed", []);
	} else {
		if (r.TP) {
			r.Oo = true;
			if (this.callEvent("onDynXLS", [r.id])) {
				this.loadXML(this.Ey + "" + (this.Ey.indexOf("?") != -1 ? "&" : "?") + "id=" + r.id);
			}
		}
	}
	this.setSizes();
	if (!r.Oo) {
		this.callEvent("onOpenEnd", [r.id, 1]);
	}
	this._fixAlterCss();
};
dhtmlXGridObject.prototype.Ey = "";
dhtmlXGridObject.prototype.sT = function (col, type, order) {
	var agS = "getValue";
	if (this.adH({parentNode:{grid:this}}, this.abv(col)).getDate) {
		agS = "getDate";
		type = "str";
	}
	this.forEachRow(function (id) {
		var z = this._h2.get[id];
		if (!z) {
			return;
		}
		var label = this._get_cell_value(z.buff, col, agS);
		if (type == "int") {
			z.pK = parseFloat(label);
			z.pK = isNaN(z.pK) ? -99999999999999 : z.pK;
		} else {
			z.pK = label;
		}
	});
	var self = this;
	var pos = 1;
	var akh = -1;
	if (order == "des") {
		pos = -1;
		akh = 1;
	}
	var xj = null;
	if (type == "cus") {
		xj = function (a, b) {
			return self._customSorts[col](a.pK, b.pK, order, a.id, b.id);
		};
	}
	if (type == "str") {
		xj = function (a, b) {
			return (a.pK < b.pK ? akh : (a.pK == b.pK ? 0 : pos));
		};
	}
	if (type == "int") {
		xj = function (a, b) {
			return (a.pK < b.pK ? akh : (a.pK == b.pK ? 0 : pos));
		};
	}
	if (type == "date") {
		xj = function (a, b) {
			return (Date.parse(new Date(a.pK || "01/01/1900")) - Date.parse(new Date(b.pK || "01/01/1900"))) * pos;
		};
	}
	this.ID(xj, 0);
	this.uR(0, true);
	this.callEvent("onGridReconstructed", []);
};
dhtmlXGridObject.prototype.ID = function (xj, id) {
	var ar = this._h2.get[id].bu;
	if (this.am.stablesort) {
		this.am.stablesort.call(ar, xj);
	} else {
		ar.sort(xj);
	}
	for (var i = 0; i < ar.length; i++) {
		if (ar[i].bu.length) {
			this.ID(xj, ar[i].id);
		}
		ar[i].index = i;
	}
};
dhtmlXGridObject.prototype.uR = function (id, mode) {
	this._h2_to_buff();
	var top = this.HF.scrollTop;
	this._reset_view();
	this.HF.scrollTop = top;
};
dhtmlXGridObject.prototype.ahx = function () {
	if (!this.nh) {
		this._h2.so(0, function (x) {
			if (x.buff.tagName == "TR") {
				var cs = (this.Cw ? (x.gR % 2) : (x.index % 2)) ? this.iI : this.hC;
				this.bj[x.id].className = (cs + (this.Vh ? (" " + cs + "_" + x.gR) : "")) + " " + (this.bj[x.id].Vn || "") + ((this.bj[x.id].className.indexOf("rowselected") != -1) ? " rowselected" : "");
			}
		}, this);
	}
};
dhtmlXGridObject.prototype.MN = function (id, dir) {
	var x = this._h2.get[id];
	var p = x.parent.bu[x.index + dir];
	if ((!p) || (p.parent != x.parent)) {
		return;
	}
	var state = [x.state, p.state];
	this.collapseKids(this.bj[x.id]);
	this.collapseKids(this.bj[p.id]);
	var ind = this.am.bP(this.bj[id]);
	var bInd = this.aD.bP(this.bj[id]);
	var aoL = this.obj.rows[0].parentNode.removeChild(this.am[ind]);
	var If = this.am[ind + ((dir == 1) ? 2 : dir)];
	if (If) {
		If.parentNode.insertBefore(aoL, If);
	} else {
		this.obj.rows[0].parentNode.appendChild(aoL);
	}
	this.am.yk(ind, ind + dir);
	this.aD.yk(bInd, bInd + dir);
	this._h2.aqd(p, x);
	if (state[0] == "minus") {
		this.expandKids(this.bj[x.id]);
	}
	if (state[1] == "minus") {
		this.expandKids(this.bj[p.id]);
	}
	this._fixAlterCss(Math.min(ind, ind + dir));
};
function eXcell_tree(cell) {
	if (cell) {
		this.cell = cell;
		this.grid = this.cell.parentNode.grid;
	}
	this.isDisabled = function () {
		return this.cell._disabled || this.grid.ZU;
	};
	this.edit = function () {
		if ((this.er) || (this.grid.ZU)) {
			return;
		}
		this.er = this.cell.parentNode.JT;
		this.val = this.DB();
		this.cell.CZ = ((!this.grid.hu) && (cn || gP || aq)) ? "INPUT" : "TEXTAREA";
		this.er.innerHTML = "<" + this.cell.CZ + " class='dhx_combo_edit' type='text' style='height:" + (this.cell.offsetHeight - 6) + "px;width:100%;border:0px;margin:0px;padding:0px;padding-top:" + (aq ? 1 : 2) + "px;overflow:hidden;'></" + this.cell.CZ + ">";
		this.er.childNodes[0].onmousedown = function (e) {
			(e || event).cancelBubble = true;
		};
		this.er.childNodes[0].onselectstart = function (e) {
			if (!e) {
				e = event;
			}
			e.cancelBubble = true;
			return true;
		};
		if (aq) {
			this.er.style.top = "1px";
		}
		this.er.className += " editable";
		this.er.firstChild.onclick = function (e) {
			(e || event).cancelBubble = true;
		};
		this.er.firstChild.value = this.val;
		this.obj = this.er.firstChild;
		this.er.firstChild.style.width = Math.max(0, this.cell.offsetWidth - this.er.offsetLeft) + "px";
		this.er.firstChild.focus();
		if (_isIE) {
			this.er.firstChild.focus();
		}
	};
	this.detach = function () {
		if (!this.er) {
			return;
		}
		this.setLabel(this.er.firstChild.value);
		this.er.className = this.er.className.replace("editable", "");
		var z = (this.val != this.er.innerHTML);
		if (aq) {
			this.er.style.top = "2px";
		}
		this.obj = this.er = null;
		return (z);
	};
	this.getValue = function () {
		return this.DB();
	};
	this.hW = function (url) {
		this.cell.parentNode.JW.nextSibling.src = this.grid.iconURL + url;
		this.grid._h2.get[this.cell.parentNode.idd].image = url;
	};
	this.afl = function () {
		this.grid._h2.get[this.cell.parentNode.idd].image;
	};
	this.setLabel = function (val) {
		this.je(val);
	};
	this.DB = function (val) {
		return this.cell.parentNode.JT.innerHTML;
	};
}
eXcell_tree.prototype = new gD;
eXcell_tree.prototype.je = function (content) {
	this.cell.parentNode.JT.innerHTML = content;
	this.grid.callEvent("onCellChanged", [this.cell.parentNode.idd, this.cell._cellIndex, content]);
};
eXcell_tree.prototype.setValue = function (sg) {
	if (this.cell.parentNode.JW) {
		return this.setLabel(sg);
	}
	if ((this.grid.kj.eg == null) || (this.grid.kj.eg != this.grid.eg)) {
		var kj = {};
		kj.amo = "<img src='" + this.grid.eg + "blank.gif' align='absmiddle' class='space'>";
		kj.abD = "<img src='" + this.grid.eg;
		kj.imsti = "<img src='" + (this.grid.iconURL || this.grid.eg);
		kj.ZY = "' align='absmiddle' onclick='this." + (cn ? "" : "parentNode.") + "parentNode.parentNode.parentNode.parentNode.grid.doExpand(this);event.cancelBubble=true;'>";
		kj.plus = kj.abD + "plus.gif" + kj.ZY;
		kj.minus = kj.abD + "minus.gif" + kj.ZY;
		kj.blank = kj.abD + "blank.gif" + kj.ZY;
		kj.start = "<div class='treegrid_cell' style='overflow:hidden;white-space : nowrap;height:" + (_isIE ? 20 : 18) + "px;'>";
		kj.akX = "' align='absmiddle' " + (this.grid.Mo ? (" height=\"" + this.grid.Mo + "\"") : "") + (this.grid.Qb ? (" width=\"" + this.grid.Qb + "\"") : "") + " ><span " + ((aq || cU) ? "style='position:relative;top:2px;'" : "") + "id='nodeval'>";
		kj.close = "</span></div>";
		this.grid.kj = kj;
	}
	var _h2 = this.grid._h2;
	var kj = this.grid.kj;
	var Mj = this.cell.parentNode.idd;
	var row = this.grid._h2.get[Mj];
	if (this.grid.Ey || this.grid.mI) {
		row.agN = (row.agN || (this.cell.parentNode._attrs["xmlkids"] && (row.state != "minus")));
		row.TP = !!row.agN;
	}
	row.image = row.image || (this.cell._attrs["image"] || "leaf.gif");
	row.label = sg;
	var html = [kj.start];
	for (var i = 0; i < row.gR; i++) {
		html.push(kj.amo);
	}
	if (row.agN) {
		html.push(kj.plus);
		row.state = "plus";
	} else {
		html.push(kj.abD + row.state + ".gif" + kj.ZY);
	}
	html.push(kj.imsti);
	html.push(row.image);
	html.push(kj.akX);
	html.push(row.label);
	html.push(kj.close);
	this.cell.innerHTML = html.join("");
	this.cell._treeCell = true;
	this.cell.parentNode.JW = this.cell.childNodes[0].childNodes[row.gR];
	this.cell.parentNode.JT = this.cell.childNodes[0].childNodes[row.gR + 2];
	if (cn) {
		this.cell.vAlign = "top";
	}
	if (row.parent.id != 0 && row.parent.state == "plus") {
		this.grid.cO(row.parent, false);
		this.cell.parentNode.WX = true;
	}
	this.grid.callEvent("onCellChanged", [Mj, this.cell._cellIndex, sg]);
};
dhtmlXGridObject.prototype._process_tree_xml = function (xml, top, qc) {
	this._parsing = true;
	var main = false;
	if (!top) {
		this.render_row = this.render_row_tree;
		main = true;
		top = xml.cR(this.xml.top);
		qc = top.getAttribute("parent") || 0;
		if (qc == "0") {
			qc = 0;
		}
		if (!this._h2) {
			this._h2 = new dhtmlxHierarchy();
		}
		if (this.aC) {
			this.aC._h2 = this._h2;
		}
	}
	var rows = xml.et(this.xml.row, top);
	this.ahl = this.ahl || [];
	for (var i = 0; i < rows.length; i++) {
		var id = rows[i].getAttribute("id");
		if (!id) {
			id = this.uid();
			rows[i].setAttribute("id", id);
		}
		var row = this._h2.add(id, qc);
		row.buff = {idd:id, data:rows[i], _parser:this._process_xml_row, _locator:this._get_xml_data};
		if (rows[i].getAttribute("open")) {
			row.state = "minus";
			this.ahl.push(id);
		}
		this.bj[id] = row.buff;
		this._process_tree_xml(xml, rows[i], id);
	}
	if (main) {
		if (!rows.length) {
			this._h2.JA(qc, "state", dhtmlXGridObject.uT);
		} else {
			if (qc != 0 && !this.ahK) {
				this._h2.JA(qc, "state", "minus");
			}
		}
		for (var i = 0; i < this.ahl.length; i++) {
			var r = this._h2.get[this.ahl[i]];
			if (!r.bu.length) {
				r.state = dhtmlXGridObject.uT;
			}
		}
		this.cO(this._h2.get[qc]);
		this._h2_to_buff();
		if (qc != 0 && this.ahK) {
			this.hx(qc);
		} else {
			if (this.aW) {
				this.uR();
			} else {
				this.render_dataset();
			}
		}
		if (this.Ey) {
			for (var i = 0; i < this.ahl.length; i++) {
				var r = this._h2.get[this.ahl[i]];
				if (r.TP) {
					this.expandKids({idd:r.id});
				}
			}
		}
		this.ahl = [];
		if (this.mI === false) {
			this.forEachRow(function (id) {
				this.render_row_tree(0, id);
			});
		}
		this._parsing = false;
		if (qc != 0 && !this.ahK) {
			this.callEvent("onOpenEnd", [qc, 1]);
		}
	}
	return xml.ai.responseXML ? xml.ai.responseXML : xml.ai;
};
dhtmlXGridObject.prototype._h2_to_buff = function (top) {
	if (!top) {
		top = this._h2.get[0];
		this.aD = new dhtmlxArray();
	}
	for (var i = 0; i < top.bu.length; i++) {
		this.aD.push(top.bu[i].buff);
		if (top.bu[i].state == "minus") {
			this._h2_to_buff(top.bu[i]);
		}
	}
};
dhtmlXGridObject.prototype.render_row_tree = function (ind, id) {
	if (id) {
		var r = this._h2.get[id];
		r = r ? r.buff : r;
	} else {
		var r = this.aD[ind];
	}
	if (!r) {
		return -1;
	}
	if (r._parser) {
		if (this.bj[r.idd] && this.bj[r.idd].tagName == "TR") {
			return this._h2.get[r.idd].buff = this.aD[ind] = this.bj[r.idd];
		}
		var row = this.uO(r.idd);
		this.bj[r.idd] = row;
		if (!id) {
			this.aD[ind] = row;
		}
		this._h2.get[r.idd].buff = row;
		r._parser.call(this, row, r.data);
		this.jQ(row);
		return row;
	}
	return r;
};
dhtmlXGridObject.prototype.yE = function (node, x) {
	if (x) {
		this._h2.so(x.id, function (x) {
			this.yE(null, x);
			delete this.bj[x.id];
		}, this);
		return;
	}
	var ind = this.getRowIndex(node.idd);
	var x = this._h2.get[node.idd];
	if (ind != -1 && ind !== this.undefined) {
		var len = 1;
		if (x && x.state == "minus") {
			len += this.jS(x.id, 0);
		}
		for (var i = 0; i < len; i++) {
			if (this.am[i + ind]) {
				this.am[i + ind].parentNode.removeChild(this.am[i + ind]);
			}
		}
		if (this.aC) {
			for (var i = 0; i < len; i++) {
				this.aC.am[i + ind].parentNode.removeChild(this.aC.am[i + ind]);
			}
			if (len > 1) {
				this.aC.am.splice(ind + 1, len - 1);
			}
		}
		this.am.splice(ind, len);
		this.aD.splice(ind, len);
	}
	if (!x) {
		return;
	}
	this.yE(null, x);
	delete this.bj[x.id];
	if (x.parent.bu.length == 1) {
		this._h2.JA(x.parent.id, "state", dhtmlXGridObject.uT);
		this.cO(x.parent);
	}
	this._h2.remove(x.id);
};
dhtmlXGridObject.prototype.hx = function (cq) {
	var y = this._h2.get[cq || 0];
	var x = this.dz(cq || 0);
	if (!x) {
		return;
	}
	if (y.parent && y.parent.id != 0) {
		this.hx(y.parent.id);
	}
	this.expandKids(x);
};
dhtmlXGridObject.prototype.FE = dhtmlXGridObject.prototype.hY;
dhtmlXGridObject.prototype.hY = function (oO, text, ind, parent_id, img, child) {
	if (!this._h2) {
		return this.FE(oO, text, ind);
	}
	parent_id = parent_id || 0;
	var Uz = this.cellType.bP("tree");
	if (typeof (text) == "string") {
		text = text.split(this.gX);
	}
	var row = this._h2.get[oO];
	if (!row) {
		if (parent_id == 0) {
			ind = this.aD.length;
		} else {
			ind = this.getRowIndex(parent_id) + 1;
			if (this._h2.get[parent_id].state == "minus") {
				ind += this.jS(parent_id, 0);
			} else {
				this.WX = true;
			}
		}
	}
	row = row || this._h2.add(oO, parent_id);
	row.image = img;
	row.agN = child;
	return row.buff = this.FE(oO, text, ind);
};
dhtmlXGridObject.prototype.alo = function (oO, text, sibl_id, img, child) {
	var sb = this.bj[sibl_id];
	if (!sb) {
		return;
	}
	if (!this._h2) {
		return this.hY(oO, text, this.getRowIndex(sibl_id));
	}
	var qc = this._h2.get[sibl_id].parent.id;
	var ind = this.getRowIndex(sibl_id);
	if (ind == -1) {
		this.WX = true;
	}
	this._h2.acA(oO, qc, sibl_id);
	return this.hY(oO, text, ind, this._h2.get[sibl_id].parent.id, img, child);
};
dhtmlXGridObject.prototype.amC = function (oO, text, sibl_id, img, child) {
	var sb = this.bj[sibl_id];
	if (!sb) {
		return;
	}
	if (!this._h2) {
		return this.hY(oO, text, this.getRowIndex(sibl_id) + 1);
	}
	var qc = this._h2.get[sibl_id].parent.id;
	var ind = this.getRowIndex(sibl_id);
	if (ind == -1) {
		this.WX = true;
	}
	if (this._h2.get[sibl_id].state == "minus") {
		ind += this.jS(sibl_id, 0) + 1;
	} else {
		ind++;
	}
	this._h2.Oj(oO, qc, sibl_id);
	return this.hY(oO, text, ind, qc, img, child);
};
dhtmlXGridObject.prototype.enableSmartXMLParsing = function (mode) {
	this.mI = ap(mode);
};
dhtmlXGridObject.prototype.DF = function (QC, from_row_id, zH) {
	var z = this.cellType.bP("tree");
	for (i = 0; i < QC.cells.length; i++) {
		if (i != z) {
			this.cells(zH, i).setValue(this.cells(from_row_id, i).getValue());
		} else {
			this.cells(zH, i).je(this.cells(from_row_id, i).getValue());
		}
	}
};
dhtmlXGridObject.prototype.KW = function (cq) {
	var x = this.dz(cq);
	if (!x) {
		return;
	}
	this.collapseKids(x);
};
dhtmlXGridObject.prototype.cx = function (cq) {
	var z = this._h2.get[cq];
	if (!z) {
		return;
	}
	while (z.bu.length) {
		this.deleteRow(z.bu[0].id);
	}
};
dhtmlXGridObject.prototype.Fx = function (cq) {
	var str = [];
	var z = this._h2.get[cq || 0];
	if (z) {
		for (var i = 0; i < z.bu.length; i++) {
			str.push(z.bu[i].id);
			if (z.bu[i].bu.length) {
				str = str.concat(this.Fx(z.bu[i].id).split(this.gX));
			}
		}
	}
	return str.join(this.gX);
};
dhtmlXGridObject.prototype.FI = function (cq, ind) {
	var z = this._h2.get[cq || 0];
	if (!z) {
		return null;
	}
	return (z.bu[ind] ? z.bu[ind].id : null);
};
dhtmlXGridObject.prototype.getItemText = function (cq) {
	return this.cells(cq, this.cellType.bP("tree")).DB();
};
dhtmlXGridObject.prototype.KL = function (cq) {
	var z = this._h2.get[cq || 0];
	if (!z) {
		return;
	}
	if (z.state == "minus") {
		return true;
	}
	return false;
};
dhtmlXGridObject.prototype.getParentId = function (cq) {
	var z = this._h2.get[cq || 0];
	if ((!z) || (!z.parent)) {
		return null;
	}
	return z.parent.id;
};
dhtmlXGridObject.prototype.Mn = function (cq) {
	var str = [];
	var z = this._h2.get[cq || 0];
	if (z) {
		for (var i = 0; i < z.bu.length; i++) {
			str.push(z.bu[i].id);
		}
	}
	return str.join(this.gX);
};
dhtmlXGridObject.prototype.expandAll = function () {
	this.CG(0);
	this._h2_to_buff();
	this._reset_view();
	this.setSizes();
	this.callEvent("onGridReconstructed", []);
	if (this._redrawLines) {
		this._redrawLines();
	}
};
dhtmlXGridObject.prototype.CG = function (z) {
	var x = this._h2.get[z].bu;
	for (var i = 0; i < x.length; i++) {
		if (x[i].bu.length) {
			this._h2.JA(x[i].id, "state", "minus");
			this.cO(x[i]);
			this.CG(x[i].id);
		}
	}
};
dhtmlXGridObject.prototype.collapseAll = function (cq) {
	this._h2.so(0, function (z) {
		if (z && z.state == "minus") {
			z.state = "plus";
			z.update = true;
			this.cO(z);
		}
	}, this);
	this._h2_to_buff();
	this._reset_view();
	this.setSizes();
	this.callEvent("onGridReconstructed", []);
	if (this._redrawLines) {
		this._redrawLines();
	}
};
dhtmlXGridObject.prototype.MD = function (cq) {
	var x = this._h2.get[cq];
	if (x && x.bu.length) {
		return x.bu.length;
	}
	if (x.TP) {
		return -1;
	}
	return 0;
};
dhtmlXGridObject.prototype.Cq = function (cq, status) {
	var x = this._h2.get[cq];
	if (!x) {
		return;
	}
	x.aaZ = (!ap(status));
};
dhtmlXGridObject.prototype.setItemText = function (cq, Zf) {
	return this.cells(cq, this.cellType.bP("tree")).setLabel(Zf);
};
dhtmlXGridObject.prototype.setItemImage = function (cq, url) {
	this._h2.get[cq].image = url;
	this.bj[cq].JW.nextSibling.src = url;
};
dhtmlXGridObject.prototype.getItemImage = function (cq) {
	this.dz(cq);
	return this._h2.get[cq].image;
};
dhtmlXGridObject.prototype.alT = function (width, height) {
	this.Qb = width;
	this.Mo = height;
};
dhtmlXGridObject.prototype.akx = function (row) {
	return this._h2.get[row.idd].image;
};
dhtmlXGridObject.prototype.Gm = function (aQ) {
	this.attachEvent("onOpenStart", aQ);
};
dhtmlXGridObject.prototype.rV = function (aQ) {
	this.attachEvent("onOpenEnd", aQ);
};
dhtmlXGridObject.prototype.aer = function (mode) {
	this.ZU = !ap(mode);
};
dhtmlXGridObject.prototype.sS = function (cq) {
	var z = this._h2.get[cq || 0];
	if (!z) {
		return -1;
	}
	return z.gR;
};
dhtmlXGridObject.prototype.oj = function (ind, state) {
	for (i in this.bj) {
		if ((this.bj[i]) && (this.bj[i].childNodes)) {
			this.bj[i].childNodes[ind].style.display = state;
		}
	}
};
dhtmlXGridObject.uT = "blank";

