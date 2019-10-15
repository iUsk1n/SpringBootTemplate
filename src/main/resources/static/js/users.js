SBT.namespace('SBT.users.list');

SBT.users.list = function(urls){
    this.ENABLED_ENABLE  = 'true';
    this.ENABLED_DISABLE = 'false';

    this.urls = urls;

    this.dataTables = null;
}

SBT.users.list.prototype.init = function() {
    var my = this;

    my.dataTables = $('#table-users').DataTable($.extend({}, dataTableDefaultSettings, {
        processing: true,
        serverSide: true,
        ajax: my.urls.ajaxsource,
        order: [[0, 'asc']],
        columns: [
            {data: 'username'},
            {data: 'fullname'},
            {data: 'enabled'},
            {data: 'groups'},
            {data: 'comment'},
            {data: 'updatedDate', },
        ]
    }));

    $('#btn-table-users-search').on('click', function() {
        var enabledEnable = $('#table-search-enabled__enable').prop('checked');
        var enabledDisable = $('#table-search-enabled__disable').prop('checked');
        var enabled = '';
        if (enabledEnable && !enabledDisable) {
            enabled = my.ENABLED_ENABLE;
        } else if (!enabledEnable && enabledDisable) {
            enabled = my.ENABLED_DISABLE;
        }

        my.dataTables
            .column(0).search($('#table-search-username').val())
            .column(1).search($('#table-search-fullname').val())
            .column(2).search(enabled)
            //
            .column(4).search($('#table-search-comment').val())
            .draw();
    });
};
