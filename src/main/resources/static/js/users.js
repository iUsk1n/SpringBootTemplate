SBT.namespace('SBT.users.list');

SBT.users.list = function(urls){
    this.urls = urls;

    this.dataTables = null;
}

SBT.users.list.prototype.init = function() {
    var my = this;

    my.dataTables = $('#table-users').DataTable($.extend({}, dataTableDefaultSettings, {
        processing: true,
        serverSide: true,
        ajax: my.urls.ajaxsource,
        //
    }));
};
