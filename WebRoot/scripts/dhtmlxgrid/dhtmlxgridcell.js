
function dhtmlXGridCellObject(obj) {
	this.fA = function () {
		this.cell.obj = null;
		this.cell = null;
		this.grid = null;
		this.base = null;
		return null;
	};
	this.cell = obj;
	this.getValue = function () {
		if ((this.cell.firstChild) && (this.cell.firstChild.tagName == "TEXTAREA")) {
			return this.cell.firstChild.value;
		} else {
			return this.cell.innerHTML.PA();
		}
	};
	this.getMathValue = function () {
		if (this.cell.eN) {
			return this.cell.eN;
		} else {
			return this.getValue();
		}
	};
	this.getFont = function () {
		arOut = new Array(3);
		if (this.cell.style.fontFamily) {
			arOut[0] = this.cell.style.fontFamily;
		}
		if (this.cell.style.fontWeight == "bold" || this.cell.parentNode.style.fontWeight == "bold") {
			arOut[1] = "bold";
		}
		if (this.cell.style.fontStyle == "italic" || this.cell.parentNode.style.fontWeight == "italic") {
			arOut[1] += "italic";
		}
		if (this.cell.style.fontSize) {
			arOut[2] = this.cell.style.fontSize;
		} else {
			arOut[2] = "";
		}
		return arOut.join("-");
	};
	this.getTextColor = function () {
		if (this.cell.style.color) {
			return this.cell.style.color;
		} else {
			return "#000000";
		}
	};
	this.getBgColor = function () {
		if (this.cell.bgColor) {
			return this.cell.bgColor;
		} else {
			return "#FFFFFF";
		}
	};
	this.getHorAlign = function () {
		if (this.cell.style.textAlign) {
			return this.cell.style.textAlign;
		} else {
			if (this.cell.style.textAlign) {
				return this.cell.style.textAlign;
			} else {
				return "left";
			}
		}
	};
	this.getWidth = function () {
		return this.cell.scrollWidth;
	};
	this.setFont = function (val) {
		fntAr = val.split("-");
		this.cell.style.fontFamily = fntAr[0];
		this.cell.style.fontSize = fntAr[fntAr.length - 1];
		if (fntAr.length == 3) {
			if (/bold/.test(fntAr[1])) {
				this.cell.style.fontWeight = "bold";
			}
			if (/italic/.test(fntAr[1])) {
				this.cell.style.fontStyle = "italic";
			}
			if (/underline/.test(fntAr[1])) {
				this.cell.style.textDecoration = "underline";
			}
		}
	};
	this.setTextColor = function (val) {
		this.cell.style.color = val;
	};
	this.setBgColor = function (val) {
		if (val == "") {
			val = null;
		}
		this.cell.bgColor = val;
	};
	this.setHorAlign = function (val) {
		if (val.length == 1) {
			if (val == "c") {
				this.cell.style.textAlign = "center";
			} else {
				if (val == "l") {
					this.cell.style.textAlign = "left";
				} else {
					this.cell.style.textAlign = "right";
				}
			}
		} else {
			this.cell.style.textAlign = val;
		}
	};
	this.hy = function () {
		if (this.cell.hy) {
			return true;
		} else {
			return false;
		}
	};
	this.wI = function () {
		var ch = this.cell.firstChild;
		if (ch && ch.tagName == "INPUT") {
			type = ch.type;
			if (type == "radio" || type == "checkbox") {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	};
	this.isChecked = function () {
		if (this.wI()) {
			return this.cell.firstChild.checked;
		}
	};
	this.isDisabled = function () {
		return this.cell._disabled;
	};
	this.Ou = function (fl) {
		if (this.wI()) {
			if (fl != "true" && fl != 1) {
				fl = false;
			}
			this.cell.firstChild.checked = fl;
		}
	};
	this.setDisabled = function (fl) {
		if (fl != "true" && fl != 1) {
			fl = false;
		}
		if (this.wI()) {
			this.cell.firstChild.disabled = fl;
			if (this.disabledF) {
				this.disabledF(fl);
			}
		}
		this.cell._disabled = fl;
	};
}
dhtmlXGridCellObject.prototype = {getAttribute:function (name) {
	return this.cell._attrs[name];
}, setAttribute:function (name, value) {
	this.cell._attrs[name] = value;
}, getInput:function () {
	if (this.obj && (this.obj.tagName == "INPUT" || this.obj.tagName == "TEXTAREA")) {
		return this.obj;
	}
	var inps = (this.obj || this.cell).getElementsByTagName("TEXTAREA");
	if (!inps.length) {
		inps = (this.obj || this.cell).getElementsByTagName("INPUT");
	}
	return inps[0];
}};
dhtmlXGridCellObject.prototype.setValue = function (val) {
	if ((typeof (val) != "number") && (!val || val.toString().PA() == "")) {
		val = "&nbsp;";
		this.cell.mG = true;
	} else {
		this.cell.mG = false;
	}
	this.dq(val);
};
dhtmlXGridCellObject.prototype.getTitle = function () {
	return (_isIE ? this.cell.innerText : this.cell.textContent);
};
dhtmlXGridCellObject.prototype.dq = function (val, val2) {
	this.cell.innerHTML = val;
	this.grid.callEvent("onCellChanged", [this.cell.parentNode.idd, this.cell._cellIndex, (arguments.length > 1 ? val2 : val)]);
};
dhtmlXGridCellObject.prototype.setCTxtValue = function (val) {
	this.cell.innerHTML = "";
	this.cell.appendChild(document.createTextNode(val));
	this.grid.callEvent("onCellChanged", [this.cell.parentNode.idd, this.cell._cellIndex, val]);
};
dhtmlXGridCellObject.prototype.setLabel = function (val) {
	this.cell.innerHTML = val;
};
dhtmlXGridCellObject.prototype.getMath = function () {
	if (this.AB) {
		return this.val;
	} else {
		return this.getValue();
	}
};
function gD() {
	this.obj = null;
	this.val = null;
	this.changeState = function () {
		return false;
	};
	this.edit = function () {
		this.val = this.getValue();
	};
	this.detach = function () {
		return false;
	};
	this.fI = function (PN) {
		var dJ = PN;
		var uW = 0;
		var AP = 0;
		while (dJ.tagName != "BODY") {
			uW += dJ.offsetLeft;
			AP += dJ.offsetTop;
			dJ = dJ.offsetParent;
		}
		return new Array(uW, AP);
	};
}
gD.prototype = new dhtmlXGridCellObject;
function eXcell_ed(cell) {
	if (cell) {
		this.cell = cell;
		this.grid = this.cell.parentNode.grid;
	}
	this.edit = function () {
		this.cell.CZ = ((!this.grid.hu) && (cn || gP || aq)) ? "INPUT" : "TEXTAREA";
		this.val = this.getValue();
		this.obj = document.createElement(this.cell.CZ);
		this.obj.setAttribute("autocomplete", "off");
		this.obj.style.height = (this.cell.offsetHeight - (_isIE ? 4 : 4)) + "px";
		this.obj.className = "dhx_combo_edit";
		this.obj.wrap = "soft";
		this.obj.style.textAlign = this.cell.style.textAlign;
		this.obj.onclick = function (e) {
			(e || event).cancelBubble = true;
		};
		this.obj.onmousedown = function (e) {
			(e || event).cancelBubble = true;
		};
		this.obj.value = this.val;
		this.cell.innerHTML = "";
		this.cell.appendChild(this.obj);
		if (aq) {
			this.obj.style.overflow = "visible";
			if ((this.grid.hu) && (this.obj.offsetHeight >= 18) && (this.obj.offsetHeight < 40)) {
				this.obj.style.height = "36px";
				this.obj.style.overflow = "scroll";
			}
		}
		this.obj.onselectstart = function (e) {
			if (!e) {
				e = event;
			}
			e.cancelBubble = true;
			return true;
		};
		if (_isIE) {
			this.obj.focus();
		}
		this.obj.focus();
	};
	this.getValue = function () {
		if ((this.cell.firstChild) && ((this.cell.CZ) && (this.cell.firstChild.tagName == this.cell.CZ))) {
			return this.cell.firstChild.value;
		}
		if (this.cell.mG) {
			return "";
		}
		return this.cell.innerHTML.toString().PA();
	};
	this.detach = function () {
		this.setValue(this.obj.value);
		return this.val != this.getValue();
	};
}
eXcell_ed.prototype = new gD;
function eXcell_edtxt(cell) {
	if (cell) {
		this.cell = cell;
		this.grid = this.cell.parentNode.grid;
	}
	this.getValue = function () {
		if ((this.cell.firstChild) && ((this.cell.CZ) && (this.cell.firstChild.tagName == this.cell.CZ))) {
			return this.cell.firstChild.value;
		}
		if (this.cell.mG) {
			return "";
		}
		return (_isIE ? this.cell.innerText : this.cell.textContent);
	};
	this.setValue = function (val) {
		if (!val || val.toString().PA() == "") {
			val = " ";
			this.cell.mG = true;
		} else {
			this.cell.mG = false;
		}
		this.setCTxtValue(val);
	};
}
eXcell_edtxt.prototype = new eXcell_ed;
function eXcell_edn(cell) {
	if (cell) {
		this.cell = cell;
		this.grid = this.cell.parentNode.grid;
	}
	this.getValue = function () {
		if ((this.cell.firstChild) && (this.cell.firstChild.tagName == "TEXTAREA")) {
			return this.cell.firstChild.value;
		}
		if (this.cell.mG) {
			return "";
		}
		return this.grid.Sl(this.cell.innerHTML.toString().PA(), this.cell._cellIndex);
	};
	this.detach = function () {
		var tv = this.obj.value;
		this.setValue(tv);
		return this.val != this.getValue();
	};
}
eXcell_edn.prototype = new eXcell_ed;
eXcell_edn.prototype.setValue = function (val) {
	if (!val || val.toString().PA() == "") {
		this.cell.mG = true;
		return this.dq("&nbsp;", 0);
	} else {
		this.cell.mG = false;
	}
	this.dq(this.grid.PH(val, this.cell._cellIndex));
};
function eXcell_ch(cell) {
	if (cell) {
		this.cell = cell;
		this.grid = this.cell.parentNode.grid;
	}
	this.disabledF = function (fl) {
		if ((fl == true) || (fl == 1)) {
			this.cell.innerHTML = this.cell.innerHTML.replace("item_chk0.", "item_chk0_dis.").replace("item_chk1.", "item_chk1_dis.");
		} else {
			this.cell.innerHTML = this.cell.innerHTML.replace("item_chk0_dis.", "item_chk0.").replace("item_chk1_dis.", "item_chk1.");
		}
	};
	this.changeState = function () {
		if ((!this.grid.isEditable) || (this.cell.parentNode.FG) || (this.isDisabled())) {
			return;
		}
		if (this.grid.callEvent("onEditCell", [0, this.cell.parentNode.idd, this.cell._cellIndex])) {
			this.val = this.getValue();
			if (this.val == "1") {
				this.setValue("0");
			} else {
				this.setValue("1");
			}
			this.cell.hy = true;
			this.grid.callEvent("onEditCell", [1, this.cell.parentNode.idd, this.cell._cellIndex]);
			this.grid.callEvent("onCheckbox", [this.cell.parentNode.idd, this.cell._cellIndex, (this.val != "1")]);
			this.grid.callEvent("onCheck", [this.cell.parentNode.idd, this.cell._cellIndex, (this.val != "1")]);
		} else {
			this.editor = null;
		}
	};
	this.getValue = function () {
		return this.cell.md ? this.cell.md.toString() : "0";
	};
	this.wI = function () {
		return true;
	};
	this.isChecked = function () {
		if (this.getValue() == "1") {
			return true;
		} else {
			return false;
		}
	};
	this.Ou = function (fl) {
		this.setValue(fl.toString());
	};
	this.detach = function () {
		return this.val != this.getValue();
	};
	this.edit = null;
}
eXcell_ch.prototype = new gD;
eXcell_ch.prototype.setValue = function (val) {
	this.cell.style.verticalAlign = "middle";
	if (val) {
		val = val.toString().PA();
		if ((val == "false") || (val == "0")) {
			val = "";
		}
	}
	if (val) {
		val = "1";
		this.cell.md = "1";
	} else {
		val = "0";
		this.cell.md = "0";
	}
	var obj = this;
	this.dq("<img src='" + this.grid.eg + "item_chk" + val + ".gif' onclick='new eXcell_ch(this.parentNode).changeState();(arguments[0]||event).cancelBubble=true;'>", this.cell.md);
};
function eXcell_ra(cell) {
	this.base = eXcell_ch;
	this.base(cell);
	this.grid = cell.parentNode.grid;
	this.disabledF = function (fl) {
		if ((fl == true) || (fl == 1)) {
			this.cell.innerHTML = this.cell.innerHTML.replace("radio_chk0.", "radio_chk0_dis.").replace("radio_chk1.", "radio_chk1_dis.");
		} else {
			this.cell.innerHTML = this.cell.innerHTML.replace("radio_chk0_dis.", "radio_chk0.").replace("radio_chk1_dis.", "radio_chk1.");
		}
	};
	this.changeState = function (mode) {
		if (mode === false && this.getValue() == 1) {
			return;
		}
		if ((!this.grid.isEditable) || (this.cell.parentNode.FG)) {
			return;
		}
		if (this.grid.callEvent("onEditCell", [0, this.cell.parentNode.idd, this.cell._cellIndex]) != false) {
			this.val = this.getValue();
			if (this.val == "1") {
				this.setValue("0");
			} else {
				this.setValue("1");
			}
			this.cell.hy = true;
			this.grid.callEvent("onEditCell", [1, this.cell.parentNode.idd, this.cell._cellIndex]);
			this.grid.callEvent("onCheckbox", [this.cell.parentNode.idd, this.cell._cellIndex, (this.val != "1")]);
			this.grid.callEvent("onCheck", [this.cell.parentNode.idd, this.cell._cellIndex, (this.val != "1")]);
		} else {
			this.editor = null;
		}
	};
	this.edit = null;
}
eXcell_ra.prototype = new eXcell_ch;
eXcell_ra.prototype.setValue = function (val) {
	this.cell.style.verticalAlign = "middle";
	if (val) {
		val = val.toString().PA();
		if ((val == "false") || (val == "0")) {
			val = "";
		}
	}
	if (val) {
		if (!this.grid.afF) {
			this.grid.afF = [];
		}
		if (this.grid.afF[this.cell._cellIndex]) {
			var z = this.grid.cells4(this.grid.afF[this.cell._cellIndex]);
			z.setValue("0");
			if (this.grid.bj[z.cell.parentNode.idd]) {
				this.grid.callEvent("onEditCell", [1, z.cell.parentNode.idd, z.cell._cellIndex]);
			}
		}
		this.grid.afF[this.cell._cellIndex] = this.cell;
		val = "1";
		this.cell.md = "1";
	} else {
		val = "0";
		this.cell.md = "0";
	}
	this.dq("<img src='" + this.grid.eg + "radio_chk" + val + ".gif' onclick='new eXcell_ra(this.parentNode).changeState(false);'>", this.cell.md);
};
function eXcell_txt(cell) {
	if (cell) {
		this.cell = cell;
		this.grid = this.cell.parentNode.grid;
	}
	this.edit = function () {
		this.val = this.getValue();
		this.obj = document.createElement("TEXTAREA");
		this.obj.className = "dhx_textarea";
		this.obj.onclick = function (e) {
			(e || event).cancelBubble = true;
		};
		var kw = this.grid.fI(this.cell);
		this.obj.value = this.val;
		this.obj.style.display = "";
		this.obj.style.textAlign = this.cell.style.textAlign;
		if (aq) {
			var z_ff = document.createElement("DIV");
			z_ff.appendChild(this.obj);
			z_ff.style.overflow = "auto";
			z_ff.className = "dhx_textarea";
			this.obj.style.margin = "0px 0px 0px 0px";
			this.obj.style.border = "0px";
			this.obj = z_ff;
		}
		document.body.appendChild(this.obj);
		if (cU) {
			this.obj.onkeypress = function (ev) {
				if (ev.keyCode == 9) {
					return false;
				}
			};
		}
		this.obj.onkeydown = function (e) {
			var ev = (e || event);
			if (ev.keyCode == 9) {
				globalActiveDHTMLGridObject.aL.focus();
				globalActiveDHTMLGridObject.bQ({keyCode:ev.keyCode, shiftKey:ev.shiftKey, srcElement:"0"});
				return false;
			}
		};
		this.obj.style.left = kw[0] + "px";
		this.obj.style.top = kw[1] + this.cell.offsetHeight + "px";
		if (this.cell.offsetWidth < 200) {
			var pw = 200;
		} else {
			var pw = this.cell.offsetWidth;
		}
		this.obj.style.width = pw + (aq ? 18 : 16) + "px";
		if (aq) {
			this.obj.firstChild.style.width = parseInt(this.obj.style.width) + "px";
			this.obj.firstChild.style.height = this.obj.offsetHeight - 3 + "px";
		}
		if (_isIE) {
			this.obj.select();
			this.obj.value = this.obj.value;
		}
		if (aq) {
			this.obj.firstChild.focus();
		} else {
			this.obj.focus();
		}
	};
	this.detach = function () {
		var afi = "";
		if (aq) {
			afi = this.obj.firstChild.value;
		} else {
			afi = this.obj.value;
		}
		if (afi == "") {
			this.cell.mG = true;
		} else {
			this.cell.mG = false;
		}
		this.setValue(afi);
		document.body.removeChild(this.obj);
		this.obj = null;
		return this.val != this.getValue();
	};
	this.getValue = function () {
		if (this.obj) {
			if (aq) {
				return this.obj.firstChild.value;
			} else {
				return this.obj.value;
			}
		}
		if (this.cell.mG) {
			return "";
		}
		if ((!this.grid.hu)) {
			return this.cell.VC || this.cell.innerHTML;
		} else {
			return this.cell.innerHTML.replace(/<br[^>]*>/gi, "\n").PA();
		}
	};
}
eXcell_txt.prototype = new gD;
function eXcell_txttxt(cell) {
	if (cell) {
		this.cell = cell;
		this.grid = this.cell.parentNode.grid;
	}
	this.getValue = function () {
		if ((this.cell.firstChild) && (this.cell.firstChild.tagName == "TEXTAREA")) {
			return this.cell.firstChild.value;
		}
		if (this.cell.mG) {
			return "";
		}
		if ((!this.grid.hu) && this.cell.VC) {
			return this.cell.VC;
		}
		return (_isIE ? this.cell.innerText : this.cell.textContent);
	};
	this.setValue = function (val) {
		this.cell.VC = val;
		if (!val || val.toString().PA() == "") {
			val = " ";
		}
		this.setCTxtValue(val);
	};
}
eXcell_txttxt.prototype = new eXcell_txt;
eXcell_txt.prototype.setValue = function (val) {
	if (!val || val.toString().PA() == "") {
		val = "&nbsp;";
		this.cell.mG = true;
	} else {
		this.cell.mG = false;
	}
	this.cell.VC = val;
	if ((!this.grid.hu)) {
		this.dq(val, val);
	} else {
		this.dq(val.replace(/\n/g, "<br/>"), val);
	}
};
function eXcell_co(cell) {
	if (cell) {
		this.cell = cell;
		this.grid = this.cell.parentNode.grid;
		this.combo = (this.cell.cl || this.grid.cf(this.cell._cellIndex));
		this.editable = true;
	}
	this.eW = function () {
		var z = this.list.options[this.list.selectedIndex + 1];
		if (z) {
			z.selected = true;
		}
		this.obj.value = this.list.options[this.list.selectedIndex].text;
		return true;
	};
	this.Kc = function () {
		if (this.list.selectedIndex != 0) {
			var z = this.list.options[this.list.selectedIndex - 1];
			if (z) {
				z.selected = true;
			}
			this.obj.value = this.list.options[this.list.selectedIndex].text;
		}
		return true;
	};
	this.edit = function () {
		this.val = this.getValue();
		this.text = this.getText().PA();
		var kw = this.grid.fI(this.cell);
		this.obj = document.createElement("TEXTAREA");
		this.obj.className = "dhx_combo_edit";
		this.obj.style.height = (this.cell.offsetHeight - 4) + "px";
		this.obj.wrap = "soft";
		this.obj.style.textAlign = this.cell.style.textAlign;
		this.obj.onclick = function (e) {
			(e || event).cancelBubble = true;
		};
		this.obj.value = this.text;
		this.obj.onselectstart = function (e) {
			if (!e) {
				e = event;
			}
			e.cancelBubble = true;
			return true;
		};
		var kx = this;
		this.obj.onkeyup = function (e) {
			var Gb = (e || event).keyCode;
			if (Gb == 38 || Gb == 40 || Gb == 9) {
				return;
			}
			var val = this.readonly ? String.fromCharCode(Gb) : this.value;
			var c = kx.list.options;
			for (var i = 0; i < c.length; i++) {
				if (c[i].text.indexOf(val) == 0) {
					return c[i].selected = true;
				}
			}
		};
		this.list = document.createElement("SELECT");
		this.list.className = "dhx_combo_select";
		this.list.style.width = this.cell.offsetWidth + "px";
		this.list.style.left = kw[0] + "px";
		this.list.style.top = kw[1] + this.cell.offsetHeight + "px";
		this.list.onclick = function (e) {
			var ev = e || window.event;
			var cell = ev.target || ev.srcElement;
			if (cell.tagName == "OPTION") {
				cell = cell.parentNode;
			}
			kx.editable = false;
			kx.grid.editStop();
		};
		var Rp = this.combo.Ln();
		var fl = false;
		var yn = 0;
		for (var i = 0; i < Rp.length; i++) {
			var val = this.combo.get(Rp[i]);
			this.list.options[this.list.options.length] = new Option(val, Rp[i]);
			if (Rp[i] == this.val) {
				yn = this.list.options.length - 1;
				fl = true;
			}
		}
		if (fl == false) {
			this.list.options[this.list.options.length] = new Option(this.text, this.val === null ? "" : this.val);
			yn = this.list.options.length - 1;
		}
		document.body.appendChild(this.list);
		this.list.size = "6";
		this.aly = 1;
		if (this.editable) {
			this.cell.innerHTML = "";
		} else {
			this.obj.style.width = "1px";
			this.obj.style.height = "1px";
		}
		this.cell.appendChild(this.obj);
		this.list.options[yn].selected = true;
		if ((!aq) || (this.editable)) {
			this.obj.focus();
			this.obj.focus();
		}
		if (!this.editable) {
			this.obj.style.visibility = "hidden";
			this.list.focus();
			this.list.onkeydown = function (e) {
				e = e || window.event;
				kx.grid.setActive(true);
				if (e.keyCode < 30) {
					return kx.grid.bQ({target:kx.cell, keyCode:e.keyCode, shiftKey:e.shiftKey, ctrlKey:e.ctrlKey});
				}
			};
		}
	};
	this.getValue = function () {
		return ((this.cell.nf == window.undefined) ? "" : this.cell.nf);
	};
	this.detach = function () {
		if (this.val != this.getValue()) {
			this.cell.hy = true;
		}
		if (this.list.parentNode != null) {
			if (this.editable) {
				var ind = this.list.options[this.list.selectedIndex];
				if (ind && ind.text == this.obj.value) {
					this.setValue(this.list.value);
				} else {
					var combo = (this.cell.cl || this.grid.cf(this.cell._cellIndex));
					var val = combo.values.bP(this.obj.value);
					if (val != -1) {
						this.setValue(combo.kk[val]);
					} else {
						this.dq(this.cell.nf = this.obj.value);
					}
				}
			} else {
				this.setValue(this.list.value);
			}
		}
		if (this.list.parentNode) {
			this.list.parentNode.removeChild(this.list);
		}
		if (this.obj.parentNode) {
			this.obj.parentNode.removeChild(this.obj);
		}
		return this.val != this.getValue();
	};
}
eXcell_co.prototype = new gD;
eXcell_co.prototype.getText = function () {
	return this.cell.innerHTML;
};
eXcell_co.prototype.setValue = function (val) {
	if (typeof (val) == "object") {
		var hJ = this.grid.bA.et("./option", val);
		if (hJ.length) {
			this.cell.cl = new dhtmlXGridComboObject();
		}
		for (var j = 0; j < hJ.length; j++) {
			this.cell.cl.eT(hJ[j].getAttribute("value"), hJ[j].firstChild ? hJ[j].firstChild.data : "");
		}
		val = val.firstChild.data;
	}
	if ((val || "").toString().PA() == "") {
		val = null;
	}
	this.cell.nf = val;
	if (val !== null) {
		var label = (this.cell.cl || this.grid.cf(this.cell._cellIndex)).get(val);
		this.dq(label === null ? val : label, val);
	} else {
		this.dq("&nbsp;", val);
	}
};
function eXcell_coro(cell) {
	this.base = eXcell_co;
	this.base(cell);
	this.editable = false;
}
eXcell_coro.prototype = new eXcell_co;
function eXcell_cotxt(cell) {
	this.base = eXcell_co;
	this.base(cell);
}
eXcell_cotxt.prototype = new eXcell_co;
eXcell_cotxt.prototype.getText = function () {
	return (_isIE ? this.cell.innerText : this.cell.textContent);
};
eXcell_cotxt.prototype.setValue = function (val) {
	if (typeof (val) == "object") {
		var hJ = this.grid.bA.et("./option", val);
		if (hJ.length) {
			this.cell.cl = new dhtmlXGridComboObject();
		}
		for (var j = 0; j < hJ.length; j++) {
			this.cell.cl.eT(hJ[j].getAttribute("value"), hJ[j].firstChild ? hJ[j].firstChild.data : "");
		}
		val = val.firstChild.data;
	}
	if ((val || "").toString().PA() == "") {
		val = null;
	}
	if (val !== null) {
		this.setCTxtValue((this.cell.cl || this.grid.cf(this.cell._cellIndex)).get(val) || val, val);
	} else {
		this.setCTxtValue(" ", val);
	}
	this.cell.nf = val;
};
function eXcell_corotxt(cell) {
	this.base = eXcell_co;
	this.base(cell);
	this.editable = false;
}
eXcell_corotxt.prototype = new eXcell_cotxt;
function eXcell_cp(cell) {
	try {
		this.cell = cell;
		this.grid = this.cell.parentNode.grid;
	}
	catch (er) {
	}
	this.edit = function () {
		this.val = this.getValue();
		this.obj = document.createElement("SPAN");
		this.obj.style.border = "1px solid black";
		this.obj.style.position = "absolute";
		var kw = this.grid.fI(this.cell);
		this.colorPanel(4, this.obj);
		document.body.appendChild(this.obj);
		this.obj.style.left = kw[0] + "px";
		this.obj.style.top = kw[1] + this.cell.offsetHeight + "px";
	};
	this.toolDNum = function (value) {
		if (value.length == 1) {
			value = "0" + value;
		}
		return value;
	};
	this.colorPanel = function (index, parent) {
		var tbl = document.createElement("TABLE");
		parent.appendChild(tbl);
		tbl.cellSpacing = 0;
		tbl.kx = this;
		tbl.style.cursor = "default";
		tbl.onclick = function (e) {
			var ev = e || window.event;
			var cell = ev.target || ev.srcElement;
			var ed = cell.parentNode.parentNode.parentNode.kx;
			ed.setValue(cell._bg);
			ed.grid.editStop();
		};
		var wQ = 256 / index;
		for (var j = 0; j <= (256 / wQ); j++) {
			var r = tbl.insertRow(j);
			for (var i = 0; i <= (256 / wQ); i++) {
				for (var n = 0; n <= (256 / wQ); n++) {
					R = new Number(wQ * j) - (j == 0 ? 0 : 1);
					G = new Number(wQ * i) - (i == 0 ? 0 : 1);
					B = new Number(wQ * n) - (n == 0 ? 0 : 1);
					var rgb = this.toolDNum(R.toString(16)) + "" + this.toolDNum(G.toString(16)) + "" + this.toolDNum(B.toString(16));
					var c = r.insertCell(i);
					c.width = "10px";
					c.innerHTML = "&nbsp;";
					c.title = rgb.toUpperCase();
					c.style.backgroundColor = "#" + rgb;
					c._bg = "#" + rgb;
					if (this.val != null && "#" + rgb.toUpperCase() == this.val.toUpperCase()) {
						c.style.border = "2px solid white";
					}
				}
			}
		}
	};
	this.getValue = function () {
		return this.cell.firstChild._bg || "";
	};
	this.getRed = function () {
		return Number(parseInt(this.getValue().substr(1, 2), 16));
	};
	this.getGreen = function () {
		return Number(parseInt(this.getValue().substr(3, 2), 16));
	};
	this.getBlue = function () {
		return Number(parseInt(this.getValue().substr(5, 2), 16));
	};
	this.detach = function () {
		if (this.obj.offsetParent != null) {
			document.body.removeChild(this.obj);
		}
		return this.val != this.getValue();
	};
}
eXcell_cp.prototype = new gD;
eXcell_cp.prototype.setValue = function (val) {
	this.dq("<div style='width:100%;height:" + ((this.grid.hu ? this.cell.offsetHeight - 2 : 16)) + ";background-color:" + (val || "") + ";border:0px;'>&nbsp;</div>", val);
	this.cell.firstChild._bg = val;
};
function eXcell_img(cell) {
	try {
		this.cell = cell;
		this.grid = this.cell.parentNode.grid;
	}
	catch (er) {
	}
	this.getValue = function () {
		if (this.cell.firstChild.tagName == "IMG") {
			return this.cell.firstChild.src + (this.cell.titFl != null ? "^" + this.cell.VC : "");
		} else {
			if (this.cell.firstChild.tagName == "A") {
				var out = this.cell.firstChild.firstChild.src + (this.cell.titFl != null ? "^" + this.cell.VC : "");
				out += "^" + this.cell.lnk;
				if (this.cell.ZE) {
					out += "^" + this.cell.ZE;
				}
				return out;
			}
		}
	};
	this.isDisabled = function () {
		return true;
	};
}
eXcell_img.prototype = new gD;
eXcell_img.prototype.getTitle = function () {
	return this.cell.VC;
};
eXcell_img.prototype.setValue = function (val) {
	var title = val;
	if (val.indexOf("^") != -1) {
		var ar = val.split("^");
		val = ar[0];
		title = this.cell._attrs.title || ar[1];
		if (ar.length > 2) {
			this.cell.lnk = ar[2];
			if (ar[3]) {
				this.cell.ZE = ar[3];
			}
		}
		this.cell.titFl = "1";
	}
	this.dq("<img src='" + this.grid.iconURL + (val || "").PA() + "' border='0'>", val);
	if (this.cell.lnk) {
		this.cell.innerHTML = "<a href='" + this.cell.lnk + "' target='" + this.cell.ZE + "'>" + this.cell.innerHTML + "</a>";
	}
	this.cell.VC = title;
};
function eXcell_price(cell) {
	this.base = eXcell_ed;
	this.base(cell);
	this.getValue = function () {
		if (this.cell.childNodes.length > 1) {
			return this.cell.childNodes[1].innerHTML.toString().PA();
		} else {
			return "0";
		}
	};
}
eXcell_price.prototype = new eXcell_ed;
eXcell_price.prototype.setValue = function (val) {
	if (isNaN(parseFloat(val))) {
		val = this.val || 0;
	}
	var color = "green";
	if (val < 0) {
		color = "red";
	}
	this.dq("<span>$</span><span style='padding-right:2px;color:" + color + ";'>" + val + "</span>", val);
};
function eXcell_dyn(cell) {
	this.base = eXcell_ed;
	this.base(cell);
	this.getValue = function () {
		return this.cell.firstChild.childNodes[1].innerHTML.toString().PA();
	};
}
eXcell_dyn.prototype = new eXcell_ed;
eXcell_dyn.prototype.setValue = function (val) {
	if (!val || isNaN(Number(val))) {
		if (val !== "") {
			val = 0;
		}
	}
	if (val > 0) {
		var color = "green";
		var img = "dyn_up.gif";
	} else {
		if (val == 0) {
			var color = "black";
			var img = "dyn_.gif";
		} else {
			var color = "red";
			var img = "dyn_down.gif";
		}
	}
	this.dq("<div style='position:relative;padding-right:2px;width:100%;overflow:hidden;white-space:nowrap;'><img src='" + this.grid.eg + "" + img + "' height='15' style='position:absolute;top:0px;left:0px;'><span style=' padding-left:20px;width:100%;color:" + color + ";'>" + val + "</span></div>", val);
};
function eXcell_ro(cell) {
	if (cell) {
		this.cell = cell;
		this.grid = this.cell.parentNode.grid;
	}
	this.edit = function () {
	};
	this.isDisabled = function () {
		return true;
	};
	this.getValue = function () {
		return this.cell.mG ? "" : this.cell.innerHTML.toString().PA();
	};
}
eXcell_ro.prototype = new gD;
function eXcell_ron(cell) {
	this.cell = cell;
	this.grid = this.cell.parentNode.grid;
	this.edit = function () {
	};
	this.isDisabled = function () {
		return true;
	};
	this.getValue = function () {
		return this.cell.mG ? "" : this.grid.Sl(this.cell.innerHTML.toString().PA(), this.cell._cellIndex);
	};
}
eXcell_ron.prototype = new gD;
eXcell_ron.prototype.setValue = function (val) {
	if (val === 0) {
	} else {
		if (!val || val.toString().PA() == "") {
			this.dq("&nbsp;");
			return this.cell.mG = true;
		}
	}
	this.cell.mG = false;
	this.dq(val ? this.grid.PH(val, this.cell._cellIndex) : "0");
};
function eXcell_rotxt(cell) {
	this.cell = cell;
	this.grid = this.cell.parentNode.grid;
	this.edit = function () {
	};
	this.isDisabled = function () {
		return true;
	};
	this.setValue = function (val) {
		if (!val || val.toString().PA() == "") {
			val = " ";
			this.cell.mG = true;
		} else {
			this.cell.mG = false;
		}
		this.setCTxtValue(val);
	};
	this.getValue = function () {
		if (this.cell.mG) {
			return "";
		}
		return (_isIE ? this.cell.innerText : this.cell.textContent);
	};
}
eXcell_rotxt.prototype = new gD;
function dhtmlXGridComboObject() {
	this.kk = new dhtmlxArray();
	this.values = new dhtmlxArray();
	this.eT = function (Gb, value) {
		for (var i = 0; i < this.kk.length; i++) {
			if (this.kk[i] == Gb) {
				this.values[i] = value;
				return true;
			}
		}
		this.values[this.values.length] = value;
		this.kk[this.kk.length] = Gb;
	};
	this.get = function (Gb) {
		for (var i = 0; i < this.kk.length; i++) {
			if (this.kk[i] == Gb) {
				return this.values[i];
			}
		}
		return null;
	};
	this.clear = function () {
		this.kk = new dhtmlxArray();
		this.values = new dhtmlxArray();
	};
	this.remove = function (Gb) {
		for (var i = 0; i < this.kk.length; i++) {
			if (this.kk[i] == Gb) {
				this.kk.hd(i);
				this.values.hd(i);
				return true;
			}
		}
	};
	this.size = function () {
		var j = 0;
		for (var i = 0; i < this.kk.length; i++) {
			if (this.kk[i] != null) {
				j++;
			}
		}
		return j;
	};
	this.Ln = function () {
		var keyAr = new Array(0);
		for (var i = 0; i < this.kk.length; i++) {
			if (this.kk[i] != null) {
				keyAr[keyAr.length] = this.kk[i];
			}
		}
		return keyAr;
	};
	this.save = function () {
		this.aff = new Array();
		for (var i = 0; i < this.kk.length; i++) {
			this.aff[i] = [this.kk[i], this.values[i]];
		}
	};
	this.restore = function () {
		if (this.aff) {
			this.kk[i] = new Array();
			this.values[i] = new Array();
			for (var i = 0; i < this.aff.length; i++) {
				this.kk[i] = this.aff[i][0];
				this.values[i] = this.aff[i][1];
			}
		}
	};
	return this;
}
function qB() {
	this.kk = new dhtmlxArray();
	this.values = new dhtmlxArray();
	return this;
}
qB.prototype = new dhtmlXGridComboObject;

