webpackJsonp([18], {
	"1sSk": function(t, e) {},
	cbhK: function(t, e, n) {
		"use strict";
		Object.defineProperty(e, "__esModule", {
			value: !0
		});
		n("eNfa");
		var s = n("VsUZ"),
			a = {
				data: function() {
					return {
						roleId: ""
					}
				},
				methods: {
					saveGameDataInfo: function() {
						var t = this;
						Object(s.q)({}).then(function(e) {
							"200" == e.status ? t.$message.success("操作成功") : t.$message.error("操作失败")
						})
					}
				},
				mounted: function() {}
			},
			c = {
				render: function() {
					var t = this,
						e = t.$createElement,
						n = t._self._c || e;
					return n("div", [n("div", {
						staticClass: "cm-title"
					}, [t._v("服务器数据保存")]), t._v(" "), n("div", {
						staticClass: "link-top"
					}), t._v(" "), n("div", {
						staticClass: "cm-search-div"
					}, [n("el-tag", [t._v("\n   关闭服务器时，如果无法触发服务器保存数据，可以在此手动保存服务器数据\n  ")]), t._v(" "), n("el-button", {
						attrs: {
							slot: "append",
							type: "primary",
							icon: "el-icon-s-promotion"
						},
						on: {
							click: function(e) {
								return t.saveGameDataInfo()
							}
						},
						slot: "append"
					}, [t._v("保存当前游戏数据")])], 1)])
				},
				staticRenderFns: []
			};
		var i = n("VU/8")(a, c, !1, function(t) {
			n("1sSk")
		}, "data-v-47036d71", null);
		e.default = i.exports
	}
});
//# sourceMappingURL=18.7c0e96d661e7ccb6aac8.js.map
